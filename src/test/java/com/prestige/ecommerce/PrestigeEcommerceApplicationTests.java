package com.prestige.ecommerce;
import com.prestige.ecommerce.dao.UtilisateurRepository;
import com.prestige.ecommerce.entity.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@SpringBootTest
class PrestigeEcommerceApplicationTests {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Test
	void testFindByEmail() {
		String email = "goerges.abidbol@yopmail.fr";
		Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
		String emailFind = utilisateur.getEmail();
		assertEquals(email,emailFind);}
	@Test
	void testNoFindByEmail() {
		String email = "sabrina@gmail.com";
		Utilisateur utilisateur = utilisateurRepository.findByEmail("goerges.abidbol@yopmail.fr");
		String emailFind = utilisateur.getEmail();
		assertNotEquals(email,emailFind);}
}


