package com.project.booking.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.stereotype.Component;

import static org.apache.hc.client5.http.auth.StandardAuthScheme.BEARER;
import static org.apache.kafka.common.security.oauthbearer.internals.secured.HttpAccessTokenRetriever.AUTHORIZATION_HEADER;

@Component
public class BookingInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AbstractOAuth2Token token = (AbstractOAuth2Token) authentication.getCredentials();
        requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER, token.getTokenValue()));
    }
}