package com.example.demo.cache.service;

import com.example.demo.City;
import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @auth chenmingzhou
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private Set<User> users = new HashSet<User>();



    @CachePut(value = "user", key = "'User:'+#user.id")
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Cacheable(value = "user", key = "'User:'+#id")
    public User addUser(String id, String name, int age) {
        User user = new User();
        user.setId(1);
        user.setName("my name");
        user.setAge(1);
        users.add(user);
        return user;
    }

    @Cacheable(value = "user", key = "'User:'+#id")
    public User getStudent(int id) {
        System.out.println("not in redis cache");
        for (User user : users) {
            if (user.getId()==id) {
                return user;
            }
        }
        return null;
    }
}
