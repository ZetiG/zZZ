package com.zeti.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2020/3/27 18:17
 * @Author Zeti
 */
@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ZtWebApplicationTests.class)
public class CommonTest {

    private static String s = "test";

    private static int i = 666;

    @Test
    public void testMarkWord() {
        String s = ClassLayout.parseInstance(CommonTest.s).toPrintable();
        log.info("mark word:{}", s);

        String i = ClassLayout.parseInstance(CommonTest.i).toPrintable();
        log.info("mark word:{}", i);
    }

}
