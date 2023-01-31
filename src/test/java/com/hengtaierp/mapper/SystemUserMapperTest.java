package com.hengtaierp.mapper;

import com.hengtaierp.entity.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class SystemUserMapperTest {
    @Autowired
    SystemUserMapper systemUserMapper;

    @Test
    void test(){
        List<SystemUser> systemUsers = systemUserMapper.selectList(null);
        log.info(systemUsers+"");

    }

}