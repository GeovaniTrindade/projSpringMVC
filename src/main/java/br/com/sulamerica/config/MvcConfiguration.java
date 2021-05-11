package br.com.sulamerica.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.sulamerica.repository.UsuarioRepository;

@Configuration
@ComponentScan(basePackages = "br.com.sulamerica")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// DataSource fará a conexão com o banco mysql
	@Bean // método de configuração do Spring
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/projDesafio01?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	// Configurando a classe UsuarioRepository
	@Bean
	public UsuarioRepository getUsuarioRepository() {
		// inicializando a classe UsuarioRepository e passando
		// para ela a configuração do DataSource (Conexão com o MySQL)
		return new UsuarioRepository(getDataSource());
	}

}
