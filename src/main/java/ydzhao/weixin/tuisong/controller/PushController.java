package ydzhao.weixin.tuisong.controller;

/**
 *@ClassName PushController
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:48
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ydzhao.weixin.tuisong.util.Pusher;

@RestController
public class PushController {
    //要推送的用户openid
    private static String a = "oXbN-5xCiKcGvGUemNTf7ysW0jF8";
    private static String d = "oXbN-55M1UVmXDAV2Ftdtxo5isHo";


    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push() {
        Pusher.push(a);
        Pusher.push(d);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) {
        Pusher.push(id);
    }
}