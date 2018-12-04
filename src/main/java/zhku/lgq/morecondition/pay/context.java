package zhku.lgq.morecondition.pay;

import zhku.lgq.morecondition.entity.Channel;

public class context {
    public Channel calRecharge(Integer channlId, Integer goodsId) throws Exception {

        StrategyFactory strategyFactory = StrategyFactory.getInstance();

        Strategy strategy = strategyFactory.create(channlId);

        return strategy.calRecharge(channlId,goodsId);
    }
}
