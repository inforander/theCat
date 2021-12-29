package com.algaworks.cobranca;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itau.thecat.model.dto.BreedDTO;
import com.itau.thecat.service.TheCatService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheCatTests {

	@Autowired
	private TheCatService theCatService;

	@Test
	public void listBreeds() throws Exception {
		List<BreedDTO> listBreeds = theCatService.listBreeds();
		assertNotNull(listBreeds);
	}

	

}
