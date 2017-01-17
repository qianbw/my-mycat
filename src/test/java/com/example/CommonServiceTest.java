package com.example;

import com.example.common.dto.CourierDTO;
import com.example.service.CommonService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@TestPropertySource(
        locations = {"classpath:application.properties"})
public class CommonServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    @Qualifier("com.example.service.CommonService")
    private CommonService commonService;

    @org.junit.Test
    public void tests1() {
        CourierDTO courierDTO = new CourierDTO();

        for (int loopIdx = 1; loopIdx < 10; loopIdx++) {
            courierDTO.setName(String.valueOf(loopIdx));
            courierDTO.setId(String.valueOf(loopIdx));
            int result = commonService.addCourier(courierDTO);
            System.out.println(String.valueOf(result));
        }
    }
}
