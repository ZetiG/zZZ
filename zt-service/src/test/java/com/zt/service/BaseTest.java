package com.zt.service;

import com.zt.web.ZtWebApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试基类
 *
 * @author wangnan
 * @since 1.0.0, 2019/11/5
 **/
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZtWebApplicationTests.class)
public class BaseTest {


}
