package com.ideas2it;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.ideas2it" )
public class AppConfiguration {
      @Bean
      public InternalResourceViewResolver viewResolver(){
          InternalResourceViewResolver vr = new InternalResourceViewResolver();
          vr.setPrefix("/Web-INF/");
          vr.setSuffix(".jsp");
          return vr;
      }
}
