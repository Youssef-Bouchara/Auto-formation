package org.sid.dao;

import org.sid.entities.Etudiant;
import org.sid.entities.Formation;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
    	repositoryRestConfiguration.setReturnBodyOnCreate(true);
    	repositoryRestConfiguration.setReturnBodyOnUpdate(true);
    	repositoryRestConfiguration.exposeIdsFor(Formation.class, Etudiant.class);
    	repositoryRestConfiguration.getCorsRegistry()
                  .addMapping("/**")
                  .allowedOrigins("*")
                  .allowedHeaders("*")
                  .allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
    }
}