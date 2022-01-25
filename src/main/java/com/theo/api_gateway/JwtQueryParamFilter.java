/*******************************************************************************
 * Copyright (c) 2021, 2022 CERTH
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     theioakiti - initial API and implementation
 *******************************************************************************/
package com.theo.api_gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtQueryParamFilter implements WebFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtQueryParamFilter.class);
    private static final String JWT_QUERY_PARAM_KEY = "key";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final String jwt = exchange.getRequest().getQueryParams().getFirst(JWT_QUERY_PARAM_KEY);

        if (jwt == null) {
            // request does not contain JWT query param => continue without change
            LOGGER.info("No JWT from query params");
            return chain.filter(exchange);
        }

        LOGGER.info("Adding JWT from query param as Bearer token to HTTP Headers");
        final ServerHttpRequest updatedRequest = exchange.getRequest().mutate()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                .build();
        final ServerWebExchange updatedExchange = exchange.mutate()
                .request(updatedRequest)
                .build();
        return chain.filter(updatedExchange);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE + 99;
    }
}
