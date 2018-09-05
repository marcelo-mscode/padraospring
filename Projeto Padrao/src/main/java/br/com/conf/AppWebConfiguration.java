package br.com.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.controller.homeController.HomeController;
import br.com.daos.ProdutosDAO;



@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class,
								   JPAConfiguration.class,
								   ProdutosDAO.class})

public class AppWebConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**")
                    .addResourceLocations("/resources/");
    }
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		
	};
	
	
	@Bean
	public FormattingConversionService mvcConserConversionService(){
		
		DefaultFormattingConversionService conversionService = 
				new DefaultFormattingConversionService(true);
		
		DateFormatterRegistrar registrar =
				new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("yyy-MM-dd"));
		registrar.registerFormatters(conversionService);

		return conversionService;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
	

}
