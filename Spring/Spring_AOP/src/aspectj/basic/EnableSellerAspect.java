package aspectj.basic;

import aspectj.Seller;
import aspectj.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 引介增强用法
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "annotation.NaiveWaiter",defaultImpl = SmartSeller.class) //为NaiveWaiter添加接口实现，后者为默认的接口实现类
    public Seller seller;    //要实现的目标接口
}
