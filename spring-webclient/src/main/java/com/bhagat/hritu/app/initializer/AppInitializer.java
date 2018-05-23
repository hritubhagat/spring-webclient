package com.bhagat.hritu.app.initializer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.server.adapter.AbstractReactiveWebInitializer;

import com.bhagat.hritu.controller.WebClientConfig;

public class AppInitializer extends AbstractReactiveWebInitializer {

    @Override
    protected Class<?>[] getConfigClasses() {
        // TODO Auto-generated method stub
        return new Class[] { WebClientConfig.class };
    }
    
    @Override
    protected ApplicationContext createApplicationContext(){
       return new AnnotationConfigApplicationContext(getConfigClasses());    
    }
}
