package com.cskaoyan.mall.config.configLJW;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {

    @Bean
   public LocalValidatorFactoryBean localValidatorFactoryBean (ReloadableResourceBundleMessageSource messageSource){
        LocalValidatorFactoryBean localValidatorFactoryBean=new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;

    }
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:mymessage");
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setUseCodeAsDefaultMessage(false);
        return  messageSource;
    }
}
