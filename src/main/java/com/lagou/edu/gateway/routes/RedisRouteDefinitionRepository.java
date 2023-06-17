package com.lagou.edu.gateway.routes;

import com.lagou.edu.gateway.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * RedisRouteDefinitionRepository
 *
 * @author xianhongle
 * @data 2022/6/1 11:43
 **/
@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

    @Autowired
    private IRouteService routeService;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromIterable(routeService.getRouteDefinitions());
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            routeService.save(routeDefinition);
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            routeService.delete(id);
            return Mono.empty();
        });
    }
}
