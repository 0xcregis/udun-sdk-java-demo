package com.udun.sdk.controller;

import cn.hutool.json.JSONUtil;
import com.udun.sdk.client.UdunClient;
import com.udun.sdk.domain.Address;
import com.udun.sdk.domain.Coin;
import com.udun.sdk.domain.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiDemoController {
    Logger log = LoggerFactory.getLogger(ApiDemoController.class);
    @Autowired
    UdunClient udunClient;
    private static final String SUCCESS = "success";

    /**
     * 生成地址
     *
     * @return 返回参数
     */
    @GetMapping("/create")
    public String create() {
        Address address = udunClient.createAddress("0", "1", "1", "http://demo.com/notify");
        log.info(JSONUtil.toJsonStr(address));
        return SUCCESS;
    }

    /**
     * 提币
     *
     * @return 返回参数
     */
    @GetMapping("/withdraw")
    public String withdraw() {
        ResultMsg resultMsg = udunClient.withdraw("0xa09921e9a3886e1b2b79e8fcd27d3a61ebe0ecd9", BigDecimal.TEN,
                "520", "520",
                "42423121", "", "http://demo.com/notify");
        log.info(resultMsg.toString());
        return SUCCESS;
    }

    /**
     * 代付
     *
     * @return 返回参数
     */
    @GetMapping("proxyPay")
    public String proxyPay() {
        ResultMsg resultMsg = udunClient.proxyPay("0xa09921e9a3886e1b2b79e8fcd27d3a61ebe0ecd9", BigDecimal.TEN,
                "520", "520",
                "43242312321321", "", "http://demo.com/notify");
        log.info(resultMsg.toString());
        return SUCCESS;
    }

    /**
     * 检验地址合法性
     *
     * @return 返回参数
     */
    @GetMapping("/checkAddress")
    public String checkAddress() {
        boolean b = udunClient.checkAddress("520", "32423432");
        log.info("{}", b);
        return SUCCESS;
    }

    /**
     * 获取商户支持币种
     *
     * @return 返回参数
     */
    @GetMapping("/listSupportCoin")
    public String listSupportCoin() {
        List<Coin> coinList = udunClient.listSupportCoin(false);
        log.info("{}", coinList.size());
        return SUCCESS;
    }
}
