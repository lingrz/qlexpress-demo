package com.zq1.springdubbo;

import com.alibaba.dubbo.rpc.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zhangqi
 * @date 2019/2/22 下午5:03
 */
@Component
public class MyDubboFilter implements Filter ,InitializingBean {




    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("sss");
        return invoker.invoke(invocation);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("myDubboFilter启动");
    }
}
