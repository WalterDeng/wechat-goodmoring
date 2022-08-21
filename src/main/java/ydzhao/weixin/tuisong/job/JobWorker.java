package ydzhao.weixin.tuisong.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ydzhao.weixin.tuisong.util.Pusher;

/**
 *@ClassName JobWorker
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 16:00
 */
@Component
public class JobWorker {
    //要推送的用户openid
    private static String a = "oXbN-5xCiKcGvGUemNTf7ysW0jF8";
    private static String d = "oXbN-55M1UVmXDAV2Ftdtxo5isHo";

    @Scheduled(cron = "0 27 7 * * ?")
    public void goodMorning(){
        Pusher.push(a);
        Pusher.push(d);
    }

}
