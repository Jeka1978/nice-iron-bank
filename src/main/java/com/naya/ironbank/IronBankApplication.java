package com.naya.ironbank;

import com.nice.starterironbank.RavenListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class IronBankApplication {

    @Bean
    public RavenListener ravenListener(){
        return new RavenListener(){
            @Override
            public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
                System.out.println("This is my Raven Sender Listener");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(IronBankApplication.class, args);
    }
}
