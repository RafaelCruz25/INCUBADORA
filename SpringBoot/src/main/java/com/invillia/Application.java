package com.invillia;


import com.invillia.runner.ApplicationRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Application {

    public static void main(String[] args) {
        final var applicationContext = new AnnotationConfigApplicationContext("com.invillia");

        final Map<String, ApplicationRunner> runners = applicationContext.getBeansOfType(ApplicationRunner.class);
        runners.forEach((beanName, runner) -> runner.run());
    }

}
