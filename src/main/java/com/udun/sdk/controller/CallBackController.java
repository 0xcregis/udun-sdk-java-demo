package com.udun.sdk.controller;

import cn.hutool.json.JSONUtil;
import com.udun.sdk.config.UdunProperties;
import com.udun.sdk.domain.Trade;
import com.udun.sdk.util.UdunUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/back")
public class CallBackController {
    Logger log = LoggerFactory.getLogger(ApiDemoController.class);
    @Autowired
    UdunProperties udunProperties;

    /**
     * 处理优盾网关回调信息，包括充币和提币
     *
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param body      消息内容
     * @param sign      签名
     * @return 返回参数
     */
    @PostMapping("/notify")
    public String tradeCallback(@RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce,
                                @RequestParam("body") String body,
                                @RequestParam("sign") String sign) {
        log.info("timestamp:{},nonce:{},sign:{},body:{}", timestamp, nonce, sign, body);
        if (!UdunUtils.checkSign(udunProperties.getMerchantKey(), timestamp, nonce, body, sign)) {
            return "error";
        }
        Trade trade = JSONUtil.toBean(body, Trade.class);
        if (trade.getTradeType() == 1) {
            log.info("充币回调处理");
            //TODO
        } else if (trade.getTradeType() == 2) {
            log.info("提币回调处理");
            if (trade.getStatus() == 1) {
                log.info("审核通过");
                //TODO
            } else if (trade.getStatus() == 2) {
                log.info("审核不通过");
                //TODO
                
            } else if (trade.getStatus() == 3) {
                log.info("提币已到账");
                //TODO
            }
        }
        return "success";
    }
}
