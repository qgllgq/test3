package zhku.lgq.morecondition;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zhku.lgq.morecondition.entity.Channel;
import zhku.lgq.morecondition.repository.BankRepository;
import zhku.lgq.morecondition.repository.ChannelRepository;

import javax.annotation.Resource;
import java.util.Optional;

public class test1 {

    @Autowired
    BankRepository bankRepository;

    @Test
    public void test2(){
        String aa = "DajDhajsd";
        System.out.println(aa.substring(0,1).toLowerCase().concat(aa.substring(1)));

        Channel channel = bankRepository.findChannelByChannelId(3);

        System.out.println(channel);
    }


}
