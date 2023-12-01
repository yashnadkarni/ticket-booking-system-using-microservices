package com.yashproject.ticketmanager.config;

import com.yashproject.ticketmanager.client.PaymentClient;
import com.yashproject.ticketmanager.client.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
    @Bean
    public WebClient ticketWebClient(){
        return WebClient.builder()
                .baseUrl("http://ticket")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public TicketClient ticketClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(ticketWebClient())).build();
        return httpServiceProxyFactory.createClient(TicketClient.class);
    }

    @Bean
    public WebClient paymentWebClient(){
        return WebClient.builder()
                .baseUrl("http://payment")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public PaymentClient paymentClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(paymentWebClient())).build();
        return httpServiceProxyFactory.createClient(PaymentClient.class);
    }
}
