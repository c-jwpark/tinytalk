package com.designcraft.db.redis;

import com.designcraft.db.KeyValueDB;

import redis.clients.jedis.Jedis;

public class RedisKeyValueDB implements KeyValueDB {
	private Jedis jedis;
	
	public RedisKeyValueDB() {
		jedis = new Jedis("localhost");
	}

	@Override
	public String get(String table, String id, String key) {
		return jedis.hget(table+":"+id, key);
	}

	@Override
	public void add(String table, String id, String key, String val) {
		jedis.hset(table+":"+id, key, val);
	}

}