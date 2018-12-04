package zhku.lgq.morecondition.pay;

import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Set;

public class StrategyFactory {

    public static StrategyFactory strategyFactory = new StrategyFactory();

    private StrategyFactory(){}

    public static HashMap<Integer, String> strategy_soource= new HashMap<>();

    /**
     * zhku.lgq.morecondition.pay.Impl 扫描包
     */
    static {
        Reflections reflections = new Reflections("zhku.lgq.morecondition.pay.Impl");

        Set<Class<?>> clazzSet = reflections.getTypesAnnotatedWith(Pay.class);

        for(Class clazz : clazzSet){
            Pay pay = (Pay) clazz.getAnnotation(Pay.class);
            strategy_soource.put(pay.channelId(),clazz.getCanonicalName());
        }
    }

    public Strategy create(int channelId) throws Exception{
        String classname = strategy_soource.get(channelId);
        Class class_ = Class.forName(classname);
        return (Strategy)class_.newInstance();
    }

    public static StrategyFactory getInstance(){
        return strategyFactory;
    }
}
