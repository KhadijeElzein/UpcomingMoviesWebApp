package br.com.khadije.upcomingmovieswebapp.utils;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MethodUtils {
	public <T> Object callAPI(String url, TypeReference<T> typeReference) throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String returnedFromUrl = restTemplate.getForObject(url, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
	    Object result  = objectMapper.readValue(returnedFromUrl,typeReference);
	    return result;
	}
}
