package com.org.coop.config;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.dozer.DozerBeanMapper;
import org.jboss.logging.MessageBundle;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.org.coop.bs.config.BusinessServiceConfig;
import com.org.coop.bs.config.DozerConfig;
import com.org.coop.society.data.transaction.config.DataAppConfig;

@Configuration 
@ComponentScan(basePackages = "com.org.coop") 
@Import({DataAppConfig.class, BusinessServiceConfig.class, DozerConfig.class})
@EnableWebMvc   
//@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class WebConfig {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }

	@Bean
	public LoggingAspect getLoggingAspect() {
		return new LoggingAspect();
	}
}
