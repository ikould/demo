package com.moris.user.mapper;

import com.moris.user.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void queryAdmin() throws Exception {
        Admin admin = adminMapper.queryAdmin(0);
        System.out.println("name = " + admin);
    }
}