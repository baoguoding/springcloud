package com.baoguoding.eurekafeign.remote;


import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageApiFailFactory  implements FallbackFactory<MessageApiFeignClient> {

    public static final Logger logger = LoggerFactory.getLogger(MessageApiFailFactory.class);
    @Override
    public MessageApiFeignClient create(Throwable throwable) {
        logger.info("fallback; reason was: {}",throwable.getMessage());
        return new MessageApiFeignFallBackFactoryClient(){

            @Override
            public String getMessage(String name) {
                return "错误原因:"+throwable.getMessage();
            }
        };
    }
}
