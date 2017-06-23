package com.jibinfo.finance.service.impl.quartz;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.quartz.QuartzLogs;
import com.jibinfo.finance.entity.quartz.QuartzLogsExample;
import com.jibinfo.finance.mapper.quartz.QuartzLogsMapper;
import com.jibinfo.finance.model.PageModel;
import com.jibinfo.finance.service.quartz.QuartzLogsService;
import com.jibinfo.framework.constant.Constants;
import com.jibinfo.framework.controller.ResponseVo;
import com.jibinfo.framework.dao.base.BaseMapper;
import com.jibinfo.framework.page.Paginator;
import com.jibinfo.framework.service.AbstractBaseServiceEx;
import com.jibinfo.framework.utils.StringUtils;

/**
 * Created by admin on 2017/4/24.
 */

@Service("quartzLogsService")
public class QuartzLogsServiceImpl extends AbstractBaseServiceEx<QuartzLogsExample, QuartzLogs> implements QuartzLogsService {

    @Resource
    private QuartzLogsMapper quartzLogsMapper;

    @Override
    public BaseMapper<QuartzLogsExample, QuartzLogs> getMapper() {
        return quartzLogsMapper;
    }


    @Override
    public PageModel<QuartzLogs> getData(Integer pageNumber, Integer pageSize, QuartzLogs model) {

        Paginator paginator = new Paginator().getPaginator(pageNumber, pageSize);
        QuartzLogsExample example = new QuartzLogsExample();
        example.setOrderByClause("QDATE DESC");
        example.setPaginator(paginator);
        QuartzLogsExample.Criteria criteria = example.createCriteria().andIsDelEqualTo(Constants.NO_DEL);
        if(null != model){
            if(StringUtils.isNotEmpty(model.getQname())){
                criteria.andQnameLike("%"+model.getQname()+"%");
            }
        }

        List<QuartzLogs> quartzLogss = quartzLogsMapper.selectByExample(example);
        int count = quartzLogsMapper.countByExample(example);
        PageModel<QuartzLogs> pageModel = new PageModel<>(count,quartzLogss);

        return pageModel;
    }

    @Override
    public ResponseVo saveOrUpdate(QuartzLogs quartzLogs) {

        QuartzLogsExample example = new QuartzLogsExample();
        QuartzLogsExample.Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(Constants.NO_DEL);
		if (null != quartzLogs && null != quartzLogs.getQid()) {
			criteria.andQidEqualTo(quartzLogs.getQid());
        }
        example.setOrderByClause("QDATE ASC");
        List<QuartzLogs> quartzLogss = quartzLogsMapper.selectByExample(example);
        if(null == quartzLogs || quartzLogss.size() <= 10){
            quartzLogsMapper.insertSelective(quartzLogs);
        }
        else{
            QuartzLogs quartzLogs1 = quartzLogss.get(0);
            quartzLogs.setId(quartzLogs1.getId());
            BeanUtils.copyProperties(quartzLogs,quartzLogs1);
            quartzLogsMapper.updateByPrimaryKey(quartzLogs1);
        }
        return null;
    }
}
