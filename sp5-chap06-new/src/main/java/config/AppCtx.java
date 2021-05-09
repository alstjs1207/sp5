package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtx {

	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		System.out.println("bean Client 생성");
		return client;
	}
	
	//@Bean(initMethod = "connect", destroyMethod = "close")
	@Bean
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host");
		System.out.println("bean Client2 생성");
		return client;
	}
}
