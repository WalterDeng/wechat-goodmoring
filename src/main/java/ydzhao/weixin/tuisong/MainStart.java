package ydzhao.weixin.tuisong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 *@ClassName MainStart
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:44
 */

@SpringBootApplication
@EnableScheduling
public class MainStart {
    public static void main(String[] args) {
        SpringApplication.run(MainStart.class, args);
    }

}
