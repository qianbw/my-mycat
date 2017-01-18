package com.example;

import com.example.common.dto.CourierDTO;
import com.example.common.dto.OrderCargoDTO;
import com.example.common.dto.OrderStatusInterceptionDTO;
import com.example.common.dto.OrdersDTO;
import com.example.service.CommonService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@TestPropertySource(
        locations = {"classpath:application.properties"})
public class CommonServiceTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    @Qualifier("com.example.service.CommonService")
    private CommonService commonService;

    /**
     * 往一个分区中写数据
     */
    @org.junit.Test
    public void addCourier() {
        CourierDTO courierDTO = new CourierDTO();

        for (int loopIdx = 10; loopIdx < 11; loopIdx++) {
            courierDTO.setName(String.valueOf(loopIdx));
            courierDTO.setId(String.valueOf(loopIdx));
            int result = commonService.addCourier(courierDTO);
            System.out.println(String.valueOf(result));
        }
    }

    /**
     * 往三个分区中写数据
     */
    @org.junit.Test
    public void addOrders() {
        OrdersDTO ordersDTO = new OrdersDTO();

        for (int loopIdx = 1; loopIdx < 10; loopIdx++) {
            ordersDTO.setId(String.valueOf(loopIdx));
            ordersDTO.setInitialpoint(String.valueOf(loopIdx));
            ordersDTO.setEndpoint(String.valueOf(loopIdx));
            ordersDTO.setOrderStatus(String.valueOf(loopIdx));
            ordersDTO.setCreateTime(new Timestamp(System.currentTimeMillis()));
            ordersDTO.setModifiedTime(new Timestamp(System.currentTimeMillis()));
            int result = commonService.addOrders(ordersDTO);
            System.out.println(String.valueOf(result));
        }
    }

    /**
     * 往子表写数据，要自动跟随主表
     */
    @org.junit.Test
    public void addOrderCargo() {
        OrderCargoDTO orderCargoDTO = new OrderCargoDTO();

        for (int loopIdx = 1; loopIdx < 10; loopIdx++) {
            orderCargoDTO.setCargoId(String.valueOf(loopIdx));
            orderCargoDTO.setOrderId(String.valueOf(loopIdx));
            int result = commonService.addOrderCargo(orderCargoDTO);
            System.out.println(String.valueOf(result));
        }
    }

    /**
     * 往全局写数据，所有表的数据会一样
     */
    @org.junit.Test
    public void addOrderStatusInterception() {
        OrderStatusInterceptionDTO orderStatusInterceptionDTO = new OrderStatusInterceptionDTO();

        for (int loopIdx = 1; loopIdx < 10; loopIdx++) {
            orderStatusInterceptionDTO.setOrderStatus(String.valueOf(loopIdx));
            orderStatusInterceptionDTO.setStatusInterception(String.valueOf(loopIdx));
            int result = commonService.addOrderStatusInterception(orderStatusInterceptionDTO);
            System.out.println(String.valueOf(result));
        }
    }

    /**
     * 一个事务内同时修改Order表和OrderCargo表（一次增加一条记录，数据不跨库）
     * <property name="handleDistributedTransactions">1</property>
     * 该参数是控制分布式事务的，所以对于本case，设置为0或者1事务都会生效。
     */
    @org.junit.Test
    public void addOrderAndCargoInSingleDB() {
        try {
            commonService.addOrderAndCargoInSingleDB();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 一个事务内同时修改Order表和OrderCargo表（一次增加一条记录，数据不跨库）
     * <property name="handleDistributedTransactions">0</property>
     * 该参数是控制分布式事务的，所以对于本case，handleDistributedTransactions必须为0
     * 否则会报错误：Distributed transaction is disabled!
     */
    @org.junit.Test
    public void addOrderAndCargoInMultiDB() {
        try {
            commonService.addOrderAndCargoInMultiDB();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
