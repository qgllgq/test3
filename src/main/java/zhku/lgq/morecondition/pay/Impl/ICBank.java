package zhku.lgq.morecondition.pay.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import zhku.lgq.morecondition.entity.Channel;
import zhku.lgq.morecondition.pay.Pay;
import zhku.lgq.morecondition.pay.Strategy;
import zhku.lgq.morecondition.repository.ChannelRepository;
import zhku.lgq.morecondition.util.beanUtils;

import java.util.Optional;

@Pay(channelId = 3)
public class ICBank extends beanUtils implements Strategy {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public Channel calRecharge(Integer channlId, Integer goodsId) {

        Optional<Channel> channel = channelRepository.findById(channlId);

        return channel.get();
    }
}
