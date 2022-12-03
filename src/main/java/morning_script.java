import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import ydzhao.weixin.tuisong.util.CaiHongPi;
import ydzhao.weixin.tuisong.util.JiNianRi;
import ydzhao.weixin.tuisong.util.Tianqi;

public class morning_script {

    private static String appId = "wx7aaaaa26e815ca61";
    private static String secret = "a4bb098b933a2929297cd6fa3d71eeba";
    //模版id
//    private static String templateId = "1qlIa0yie_9xJZw9x_FUxxHV1xI_rVxnhUUv63U_dUw";
    private static String templateId = "HLUSoYFMUayZHMPNLDkVDEk5861cQ1TzbxwkFtHTcyk";

    public static void push(String openId){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                //.url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        //填写变量信息，比如天气之类的
        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        templateMessage.addData(new WxMpTemplateData("riqi",todayWeather.getString("date") + "  "+ todayWeather.getString("week"),"#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi",todayWeather.getString("text_day"),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low",todayWeather.getString("low") + "","#173177"));
        templateMessage.addData(new WxMpTemplateData("high",todayWeather.getString("high")+ "","#FF6347" ));
        templateMessage.addData(new WxMpTemplateData("lianai", JiNianRi.getLianAi()+"","#FF1493"));
        templateMessage.addData(new WxMpTemplateData("shengri",JiNianRi.getShengRi()+"","#FFA500"));

        templateMessage.addData(new WxMpTemplateData("jinju", CaiHongPi.getJinJu() + "","#C71585"));
        //templateMessage.addData(new WxMpTemplateData("jiehun",JiNianRi.getJieHun()+""));
        templateMessage.addData(new WxMpTemplateData("linzhen",JiNianRi.getLinZhen()+"","#FF6347"));
        String beizhu = "";
        if(JiNianRi.getJieHun() % 365 == 0){
            beizhu = "今天是结婚纪念日！";
        }
        if(JiNianRi.getLianAi() % 365 == 0){
            beizhu = "今天是恋爱纪念日！";
        }
        if(JiNianRi.getLinZhen() % 365 == 0){
            beizhu = "今天是结婚纪念日！";
        }
        if(JiNianRi.getShengRi() % 365 == 0){
            beizhu = "今天是你的生日！";
        }

        // length(caihongpi) < 40
        String caihongpi = CaiHongPi.getCaiHongPi();
        while(caihongpi.length() > 40){
            caihongpi = CaiHongPi.getCaiHongPi();
        }
        templateMessage.addData(new WxMpTemplateData("caihongpi", caihongpi,"#FF69B4"));

        // jinjus.len < 50
        String[] jinjus = CaiHongPi.getJinJuString();
        while(jinjus[1].length() > 50){
            jinjus = CaiHongPi.getJinJuString();
        }
        templateMessage.addData(new WxMpTemplateData("jinju1", jinjus[1] + " ","#C71585"));
        templateMessage.addData(new WxMpTemplateData("jinju2",jinjus[2] + " ","#C71585"));


        String speak_aside1 = "清晨的第一个消息希望带给你满满的元气！";
        templateMessage.addData(new WxMpTemplateData("speak_aside1", speak_aside1, "#000000"));
        String speak_aside2 = "今天的天气与你一样美好！ (*^▽^*)";
        templateMessage.addData(new WxMpTemplateData("speak_aside2", speak_aside2, "#FF9797"));
        String speak_aside3 = "今天于我们有特殊的含义 ↓ ";
        templateMessage.addData(new WxMpTemplateData("speak_aside3", speak_aside3, "#FF9797"));
        String speak_aside4 = "余生幸能与你一起！(๑′ᴗ‵๑)Ｉ Lᵒᵛᵉᵧₒᵤ❤";
        templateMessage.addData(new WxMpTemplateData("speak_aside4", speak_aside4, "#FF4040"));


        templateMessage.addData(new WxMpTemplateData("beizhu",beizhu,"#FF0000"));


        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String a = "oXbN-5xCiKcGvGUemNTf7ysW0jF8";
    private static String d = "oXbN-55M1UVmXDAV2Ftdtxo5isHo";


    public static void pusher() {
        push(a);
        push(d);
    }


    public static void main(String[] args) {
        pusher();
        System.out.println("Hello Java");
    }


}
