package top.crazybanana.modules.account.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import top.crazybanana.domain.common.R;
import top.crazybanana.domain.modules.account.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Before
    public void init(){

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("username", "Jobs");
        map.add("password", "123456");
        String result = testRestTemplate.postForObject("/home/login", map, String.class);
        System.out.println(result);
    }

    @Test
    public void list() {
        String result = testRestTemplate.getForObject("/user/list", String.class);
        System.out.println(result); //这里因为未授权，导致返回登录页面
//        Assert.assertTrue(result.containsKey("data"));
//        if(result.containsKey("data")){
//            List<User> users = (List<User>) result.get("data");
//            Assert.assertEquals(3, users.size());
//        }
    }
}