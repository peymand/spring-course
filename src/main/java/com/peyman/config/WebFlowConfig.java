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


    // A flow registry�s job is to load flow definitions and make them available
    // to the flow executor
    @Bean
    public FlowDefinitionRegistry flowRegistry() {

        return getFlowDefinitionRegistryBuilder().setBasePath("/WEB-INF/flows")
                .addFlowLocation("/checkout/checkout-flow.xml", "checkout").build();
    }

    /*
     * the flow executor is responsible for creating and executing flows,
     */
    @Bean
    public FlowExecutor flowExecutor() {

        return getFlowExecutorBuilder(flowRegistry()).build();
    }

    /*
     * Whereas the FlowHandlerMapping�s job is to direct flow requests to Spring
     * Web Flow, it�s the job of a FlowHandlerAdapter to answer that call. A
     * FlowHandlerAdapter is equivalent to a Spring MVC controller in that it
     * handles requests coming in for a flow and processes those requests
     */

    /*
     * This handler adapter is the bridge between DispatcherServlet and Spring
     * Web Flow. It handles flow requests and manipulates the flow based on
     * those requests. Here, it�s wired with a reference to the flow executor to
     * execute the flows for which it handles requests
     */
    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {

        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(flowExecutor());

        return handlerAdapter;
    }

    /*
     * A DispatcherServlet typically dispatches requests to controllers. But for
     * flows, you need a FlowHandlerMapping to help DispatcherServlet know that
     * it should send flow requests to Spring Web Flow.
     */
    @Bean
    public FlowHandlerMapping flowHandlerMapping() {

        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();

        /*
         * As you can see, the FlowHandlerMapping is wired with a reference to
         * the flow registry so it knows when a request�s URL maps to a flow.
         * For example, if you have a flow whose ID is pizza, then
         * FlowHandlerMapping will know to map a request to that flow if the
         * request�s URL pattern (relative to the application context path) is
         * /pizza.
         */

        handlerMapping.setFlowRegistry(flowRegistry());
        return handlerMapping;
    }
}
