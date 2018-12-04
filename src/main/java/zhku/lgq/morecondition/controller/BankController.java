package zhku.lgq.morecondition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhku.lgq.morecondition.entity.Channel;
import zhku.lgq.morecondition.pay.context;
import zhku.lgq.morecondition.repository.BankRepository;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @RequestMapping("/pay")
    public Channel pay(int channelId, int goodsId) throws Exception {
        context context1 = new context();
        return context1.calRecharge(channelId,goodsId);
    }

    @RequestMapping("/test")
    public Channel test(){
        System.out.println(bankRepository.findChannelByChannelId(3).getChannelName());
        return bankRepository.findChannelByChannelId(3);
    }
}
