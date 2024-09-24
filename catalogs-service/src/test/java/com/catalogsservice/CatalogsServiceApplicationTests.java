package com.catalogsservice;

import com.catalogsservice.entity.CatalogEntity;
import com.catalogsservice.repository.CatalogRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@Rollback(value = false)
@Transactional(readOnly = true)
class CatalogsServiceApplicationTests {
	@Autowired
	CatalogRepository catalogRepository;

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
	}

	@DisplayName("테스트")
	@Test
	@Transactional
	public void test_001() throws Exception{

		CatalogEntity catalogEntity1 = new CatalogEntity();
		catalogEntity1.setCreatedAt(new Date());
		catalogEntity1.setStock(1000);
		catalogEntity1.setUnitPrice(10000);
		catalogEntity1.setProductName("CATALOG-0001");
		catalogRepository.save(catalogEntity1);

		CatalogEntity catalogEntity2 = new CatalogEntity();
		catalogEntity2.setCreatedAt(new Date());
		catalogEntity2.setStock(100);
		catalogEntity2.setUnitPrice(4000);
		catalogEntity2.setProductName("CATALOG-0002");
		catalogRepository.save(catalogEntity2);

		CatalogEntity catalogEntity3 = new CatalogEntity();
		catalogEntity3.setCreatedAt(new Date());
		catalogEntity3.setStock(500);
		catalogEntity3.setUnitPrice(2000);
		catalogEntity3.setProductName("CATALOG-0003");
		catalogRepository.save(catalogEntity3);

		em.flush();


	}

}
