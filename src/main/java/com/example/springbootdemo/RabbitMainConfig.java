package com.example.springbootdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * $RabbitMainConfig
 *
 * @author coriander
 */
@Configuration
@ComponentScan({"com.coriander.rabbit.*"})
public class RabbitMainConfig {
}
