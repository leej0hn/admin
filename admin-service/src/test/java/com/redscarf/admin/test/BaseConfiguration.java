package com.redscarf.admin.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * Created by MHL on 16/4/8.
 */
@Configuration
@EnableAutoConfiguration
//@ComponentScan(
//        basePackages = {"com.redscarf.admin"}
//
//)
//@MapperScan("com.redscarf.admin.persistence.mapper")
@ImportResource(locations={"classpath:dubbo-consumer.xml"})
public class BaseConfiguration {
}
