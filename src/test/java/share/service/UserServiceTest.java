package share.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import share.entity.User;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceTest {
    final private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private UserService userService;
    @Test
    public void testGetUserById() throws Exception {
        User userById = userService.getUserById(1);
        logger.info("{}", userById);
    }
}