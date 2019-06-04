package com.nice.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

public class JedisTest {

    @Test
    public void testJedisSingle(){
        //创建一个jedis的对象
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //调用jedis对象的方法，方法名称和redis的命令一致
        jedis.set("name","nice");
        System.out.println(jedis.get("name"));
        //关闭jedis
        jedis.close();
    }

    /**
     * jedis连接池
     */
    @Test
    public void testJedisPool(){
        JedisPool pool = new JedisPool("127.0.0.1",6379);
        Jedis jedis = pool.getResource();
        System.out.println(jedis.get("name"));
        jedis.close();
        pool.close();
    }

    /**
     * jedis连接redis集群
     */
    @Test
    public void testJedisCluster(){
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.174.138",6379));
        nodes.add(new HostAndPort("192.168.174.139",6379));
        nodes.add(new HostAndPort("192.168.174.141",6379));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("name","nice");
        System.out.println(cluster.get("name"));
        cluster.close();
    }

    @Test
    public void testSpringJedisSingle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String name = jedis.get("name");
        System.out.println(name);
    }

}
