package cn.silence.butterfly.web.config;

import cn.silence.butterfly.core.exception.BizException;
import cn.silence.butterfly.core.util.result.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/05/02 21:40:59
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private final String[] swaggerPathPatterns = new String[]{
            "/doc.html", "/favicon.ico", "/**/error", "/swagger-resources", "/v2/api-docs", "/webjars/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/sys/user/**")
                .excludePathPatterns(swaggerPathPatterns);
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}

@Slf4j
class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("preHandle==>{}", request.getServletPath());
        if (request.getSession().getAttribute("userToken") == null) {
            throw new BizException(ErrorCode.NO_PERMISSION.getCode(), "The current user is not logged in!");
        }
        return true;
    }
}
