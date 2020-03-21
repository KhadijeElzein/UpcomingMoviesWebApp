package br.com.khadije.upcomingmovieswebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.khadije.upcomingmovieswebapp.facade.ApplicationStartUpFacade;

@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

   @Autowired
   ApplicationStartUpFacade facade;
	
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
	  	try {
			facade.SyncAPIData();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    return;
  }
 
} // class