package zhku.lgq.morecondition.pay;

import zhku.lgq.morecondition.entity.Channel;

public interface Strategy {

    Channel calRecharge(Integer channlId, Integer goodsId);
}
