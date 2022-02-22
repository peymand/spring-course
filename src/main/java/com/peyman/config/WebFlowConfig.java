package com.peyman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {


    @Bean
    public FlowDefinitionRegistry flowRegistry(){
        return getFlowDefinitionRegistryBuilder().setBasePath("/WEB-INF/flows")
                .addFlowLocation("/checkout/checkout-flow.xml", "checkout").build();
    }

    @Bean
    public FlowExecutor flowExecutor(){
        return getFlowExecutorBuilder(flowRegistry()).build();
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(){
        FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
        flowHandlerAdapter.setFlowExecutor(flowExecutor());
        return flowHandlerAdapter;
    }

    @Bean
    public FlowHandlerMapping handlerMapping(){
        FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
        flowHandlerMapping.setFlowRegistry(flowRegistry());
        return flowHandlerMapping;
    }
}
