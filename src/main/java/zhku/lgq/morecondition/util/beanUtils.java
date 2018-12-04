package zhku.lgq.morecondition.util;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;

@Service
public class beanUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;

    }

    public beanUtils(){
        /**
         * j加载继承该类的类，扫描成员变量
         */
        Reflections reflections = new Reflections(this.getClass(),new FieldAnnotationsScanner());

        Set<Field> fields = reflections.getFieldsAnnotatedWith(org.springframework.beans.factory.annotation.Autowired.class);

        for(Field field : fields){
            try {
            /**
             * 获得成员变量的类名
             */
                String simpleName = field.getType().getSimpleName();

                String beanname = simpleName.substring(0, 1).toLowerCase().concat(simpleName.substring(1));

                Object bean = applicationContext.getBean(beanname);

                if(bean == null)
                    return ;

                field.setAccessible(true);
                field.set(this,bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
