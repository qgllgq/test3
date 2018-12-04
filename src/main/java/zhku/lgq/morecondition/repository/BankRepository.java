package zhku.lgq.morecondition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zhku.lgq.morecondition.entity.Channel;

public interface BankRepository extends JpaRepository<Channel,Integer> {

    Channel findChannelByChannelId(int channelId);

}
