package com.ooqiu.gaming.service.admin;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by admin on 2018/8/29.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ooqiu.gaming.service.admin.mapper")
public class GamingServerServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(GamingServerServiceAdminApplication.class, args);
        //运行容器
        Main.main(args);
    }
}
