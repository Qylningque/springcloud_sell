package com.linco.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.linco.apigateway.exception.RateLimitLifterException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @Classname: RateFilter
 * @description: 限流拦截器
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 11:51
 * @Version 1.0
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    /** Google开源组件Guava , 令牌桶组件
     * RateLimiter.create(100) 此处定义放令牌的速率
     * */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 限流优先级最高，放在目前优先级最高之前
     * @return
     */
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //判断是否拿到令牌
        if(!RATE_LIMITER.tryAcquire()){
            //没有拿到令牌时
            throw new RateLimitLifterException();
        }
        return null;
    }
}
