package pl.coderslab.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.format.FormatterRegistry;
import org.springframework.context.annotation.Bean;
import pl.coderslab.converter.UserConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.*;


@Configuration
@ComponentScan("pl.coderslab")
@EnableWebMvc
@EnableTransactionManagement
public class FormatterConfig implements WebMvcConfigurer{


    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(getUserConverter());
        registry.addConverter(getTweetConverter());

    }


    @Bean
    public UserConverter getUserConverter(){ return new UserConverter(); }

    @Bean
    public TweetConverter getTweetConverter(){ return new TweetConverter(); }


}
