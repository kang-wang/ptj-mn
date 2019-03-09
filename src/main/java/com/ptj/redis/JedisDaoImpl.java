package com.ptj.redis;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

@Repository
public class JedisDaoImpl implements JedisDao{
	@Resource
	private JedisCluster jedisClients;
	@Override
	public Boolean exists(String key) {
		return jedisClients.exists(key);
	}

	@Override
	public Long del(String key) {
		return jedisClients.del(key);
	}

	@Override
	public String set(String key, String value) {
		return jedisClients.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisClients.get(key);
	}

	@Override
	public String setHasTime(String key,String value, Long time) {
		boolean keyExist = jedisClients.exists(key);
		if (keyExist){
			jedisClients.del(key);
		}
		return jedisClients.set(key, value, "NX", "EX", time);
	}

}
