package com.jibinfo.finance.service.impl.redis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.redis.Redis;
import com.jibinfo.finance.model.PageBean;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.redis.AbstractBaseRedisService;
import com.jibinfo.finance.service.redis.RedisService;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.utils.StringUtils;

@Service("redisService")
public class RedisServiceImpl extends AbstractBaseRedisService<String, String>
		implements RedisService {
	private static final Log logger = LogFactory.getLog(RedisServiceImpl.class);

	@Override
	public PageModel<Redis> getData(Integer pageNumber, Integer pageSize,
			Redis redis) {
		PageModel<Redis> pageModel = new PageModel<>();

		String key = "";
		if (null != redis && StringUtils.isNotEmpty(redis.getKey())) {
			key = "*" + redis.getKey().trim() + "*";
		} else {
			key = "*";
		}

		List<Redis> redisList = new ArrayList<>();
		Set<String> set = redisTemplate.keys(key);
		if (null != set && !set.isEmpty()) {
			for (String k : set) {
				Redis rs = new Redis();
				rs.setKey(k);

				// 根据key获取value的值
				String value = this.getValue(k);
				rs.setValue(value);

				redisList.add(rs);
			}
		}

		int firstIndex = 0;
		int endIndex = 0;
		int size = 0;
		if (null != redisList && !redisList.isEmpty()) {
			boolean flag = false;
			if (pageNumber == 0) {
				pageNumber = 1;
				flag = true;
			}

			size = redisList.size();
			PageBean pageBean = new PageBean(size);
			pageBean.setCurPage(pageNumber);
			int pagesize = pageBean.getPageSize();

			// 获得分页数据在list集合中的索引
			if (flag) {
				firstIndex = 0;
				endIndex = pagesize;
			} else {
				firstIndex = pageNumber;
				endIndex = pageNumber + pagesize;
			}
			if (endIndex > size) {
				endIndex = size;
			}
			if (firstIndex > endIndex) {
				firstIndex = 0;
				pageBean.setCurPage(1);
			}
		}

		// 截取数据集合，获得分页数据
		List<Redis> courseList = redisList.subList(firstIndex, endIndex);
		pageModel = new PageModel<>(size, courseList);
		return pageModel;
	}

	@Override
	public ResponseVo delete(String keys) {
		ResponseVo result = new ResponseVo().successResponse();
		String[] keyArr = StringUtils.split(keys, ",");
		List<String> keyList = Arrays.asList(keyArr);
		redisTemplate.delete(keyList);

		return result;
	}

	@Override
	public ResponseVo flushDb() {
		ResponseVo result = new ResponseVo().successResponse();
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
		return result;
	}

	/**
	 * 根据key获取value值
	 */
	private String getValue(final String k) {
		return (String) redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				try {
					String value = new String(connection.get(k.getBytes()),
							"UTF-8");
					return value.length() > 100 ? value.substring(0, 100)
							+ "..." : value;
				} catch (UnsupportedEncodingException e) {
					logger.error(e);
				}
				return "";
			}
		});
	}
}
