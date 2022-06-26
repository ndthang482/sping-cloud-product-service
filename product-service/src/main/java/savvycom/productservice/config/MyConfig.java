//package savvycom.productservice.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import savvycom.productservice.filter.UserFilter;
//
//@Configuration
//public class MyConfig {
//
//    @Bean
//    public FilterRegistrationBean<UserFilter> loggingFilter(){
//        FilterRegistrationBean<UserFilter> registrationBean
//                = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new UserFilter());
//        registrationBean.addUrlPatterns("/product/*");
//
//        return registrationBean;
//    }
//}
//
//
