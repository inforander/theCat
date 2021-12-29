package com.itau.thecat.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itau.thecat.model.dto.BreedDTO;

@Service
public class TheCatAPIService {

	private final static String THE_CAT_BASE_URL = "https://api.thecatapi.com/v1";

	public List<BreedDTO> listBreeds() throws URISyntaxException {

		StringBuffer query = new StringBuffer();
		//query.append("?");
		//query.append("limit=" + 10);
		//query.append("&page=" + 0);

		final URI uri = new URI(String.format("%s/breeds".concat(query.toString()), THE_CAT_BASE_URL));

		HttpHeaders headers = generateHeaders();
		HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);
		return exchange(requestEntity, HttpMethod.GET, uri, new ParameterizedTypeReference<List<BreedDTO>>() {
		});
	}

	public <I, O> O exchange(HttpEntity<I> requestEntity, HttpMethod httpMethod, URI url,
			ParameterizedTypeReference<O> responseType) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<O> responseEntity = restTemplate.exchange(url, httpMethod, requestEntity, responseType);
			return responseEntity.getBody();
		} catch (Exception e) {
			throw e;
		}
	}

	private HttpHeaders generateHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("x-api-key", "4ca265a2-2212-4cb7-9efa-c40588bf0da5");
		return headers;
	}

}
