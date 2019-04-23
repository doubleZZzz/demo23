package cn.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: ZhangZhuo
 * @Date: 2019/4/23 14:47
 * @Description:  启动类
 */
@SpringBootApplication
@PropertySource("application-demo.properties")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
