package zhku.lgq.morecondition.pay.Impl;

import zhku.lgq.morecondition.entity.Channel;
import zhku.lgq.morecondition.pay.Pay;
import zhku.lgq.morecondition.pay.Strategy;
import zhku.lgq.morecondition.util.beanUtils;

import javax.annotation.Resource;
import java.util.Optional;

//@Pay(channelId = 2)
public class JianSheBank extends beanUtils implements Strategy {
    @Override
    public Channel calRecharge(Integer channlId, Integer goodsId) {
        return null;
    }

//    @Resource
//    private ChannelRepository channelRepository;
//
//    @Override
//    public Channel calRecharge(Integer channlId, Integer goodsId) {
//
//        Optional<Channel> channel = channelRepository.findById(channlId);
//
//        return channel.get();
//    }
}
