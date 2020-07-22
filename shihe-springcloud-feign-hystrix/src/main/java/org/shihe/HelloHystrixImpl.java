package org.shihe;

import org.springframework.stereotype.Component;

/**
 * @ClassName HelloHystrixImpl
 * @Description TODO
 * @Author admin
 * @Date 2020-07-22 14:59
 * @Version 1.0
 */
@Component
public class HelloHystrixImpl implements HelloHystrixService{
    @Override
    public String hello() {
        return "调用异常！！";
    }
}
