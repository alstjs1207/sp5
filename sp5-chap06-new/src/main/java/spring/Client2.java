package spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Client2 {

	private String host;

	public void setHost(String host) {
		this.host = host;
	}

	@PostConstruct
	public void connect() {
		System.out.println("Client2.connect() 실행");
	}

	public void send() {
		System.out.println("Client2.send() to " + host);
	}

	@PreDestroy
	public void close() {
		System.out.println("Client2.close() 실행");
	}

}
