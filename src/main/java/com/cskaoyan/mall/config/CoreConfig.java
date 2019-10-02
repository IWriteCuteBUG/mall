package com.cskaoyan.mall.config;

import com.cskaoyan.mall.converter.String2DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.PostConstruct;
@Configuration
public class CoreConfig implements WebMvcConfigurer {

    @Autowired
    ConfigurableConversionService conversionService;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", buildCorsConfiguration());
        CorsFilter corsFilter = new CorsFilter(configurationSource);
        return corsFilter;
    }

    private CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        return corsConfiguration;
    }

    /**
     * 文件上传处理器
     * multipartResolver
     * 有默认的
     * @return
     */
    /*@Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(6500000);
        return commonsMultipartResolver;
    }*/


    /**
     * 转换器
     */
    /*@PostConstruct
    public void addConverter() {
        String2DateConverter string2DateConverter = new String2DateConverter();
        conversionService.addConverter(string2DateConverter);

    }*/

//    @Bean
//
//    @Primary
//    public ConfigurableConversionService conversionService() {
//        return conversionService;
//    }

    /*@Bean
    @Primary
    public ConversionServiceFactoryBean conversionService1() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(new String2DateConverter());//日期转换器
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }*/

}
