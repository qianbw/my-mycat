package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@TestPropertySource(
        locations = {"classpath:application.properties"})
public class CommonServiceTest extends AbstractJUnit4SpringContextTests {

    @org.junit.Test
    public void tests1() {
        System.out.println("1111111");
    }
}
