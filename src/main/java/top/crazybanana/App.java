package top.crazybanana;

import org.mybatis.spring.annotation.MapperScan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("top.crazybanana.modules")
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
