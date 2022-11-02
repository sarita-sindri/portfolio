package com.cryptonixlabs.portfolio.configurations;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfigurations implements WebMvcConfigurer  {
	
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver lr = new CookieLocaleResolver();
		lr.setDefaultLocale(Locale.US);
	    return lr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	}
	
	@Bean(name = "messageSource")
	public MessageSource getMessageResource()  {
		ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
		messageResource.setBasename("classpath:i18n/messages");
		messageResource.setDefaultEncoding("UTF-8");
		return messageResource;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(localeChangeInterceptor());
	}
}
