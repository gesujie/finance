package com.jibinfo.finance.service.redis;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public abstract class AbstractBaseRedisService<K extends Serializable, V extends Serializable> {
	@Resource
	protected RedisTemplate<K, V> redisTemplate;

	/**
	 * 设置redisTemplate
	 */
	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate,
			RedisTemplate<K, V> stringRedisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 获取 RedisSerializer
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}

}
