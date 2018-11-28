package org.sid;

import org.sid.rmi.BanqueRmiRemote;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class MyConfig {
	
	@Bean
	public SimpleJaxWsServiceExporter getJWS()
	{
		SimpleJaxWsServiceExporter exporter=new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/maBanque");
		return exporter;
	}
	
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext ctx)
	{
		RmiServiceExporter exporter=new RmiServiceExporter();
		exporter.setServiceName("BK");
		exporter.setService(ctx.getBean("myRmiService"));
		exporter.setServicePort(1099);
		exporter.setServiceInterface(BanqueRmiRemote.class);
		
		return exporter;
	}

}
