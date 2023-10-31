//package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//public class OperateurJUnitTest {

//    @Autowired
//     OperateurRepository operateurRepository;
//
//     OperateurServiceImpl operateurServiceImpl;
//
//    @BeforeEach
//    public void setUp() {
//
//        operateurServiceImpl = new OperateurServiceImpl(operateurRepository);
//    }
//
//    @Test
//    public void retrieveAllOperateursTest() {
//        // Arrange
//        Operateur operateur1 = new Operateur();
//        Operateur operateur2 = new Operateur();
//        operateurRepository.save(operateur1);
//        operateurRepository.save(operateur2);
//
//        // Act
//        List<Operateur> result = operateurServiceImpl.retrieveAllOperateurs();
//
//        // Assert
//        assertNotNull(result); // Vérifie que la liste renvoyée n'est pas nulle
//        assertEquals(2, result.size()); // Vérifie que la liste contient deux opérateurs (ou le nombre attendu)
//        assertTrue(result.contains(operateur1)); // Vérifie que operateur1 est dans la liste
//        assertTrue(result.contains(operateur2)); // Vérifie que operateur2 est dans la liste
//    }
//
//
//    @Test
//    public void addOperateurTest() {
//        // Arrange
//        Operateur operateur = new Operateur();
//
//        // Act
//        Operateur result = operateurServiceImpl.addOperateur(operateur);
//
//        // Assert
//        assertNotNull(result); // Vérifie que l'opérateur retourné n'est pas nul
//        assertEquals(operateur, result); // Vérifie que l'opérateur retourné est le même que celui que vous avez passé
//    }
//
//    @Test
//    public void deleteOperateurTest() {
//        // Arrange
//        Operateur operateur = new Operateur();
//        operateurRepository.save(operateur);
//
//        // Act
//        operateurServiceImpl.deleteOperateur(operateur.getIdOperateur());
//
//        // Assert
//        Optional<Operateur> deletedOperateur = operateurRepository.findById(operateur.getIdOperateur());
//        assertFalse(deletedOperateur.isPresent()); // Vérifie que l'opérateur a été supprimé (résultat vide)
//    }
//
//
//    @Test
//    public void updateOperateurTest() {
//        // Arrange
//        Operateur o = new Operateur();
//        operateurRepository.save(o);
//
//        // Modification simulée de l'objet
//        o.setNom("NouveauNom");
//        // Ajoutez d'autres ...
//
//
//
//        // Act
//        Operateur updatedOperateur = operateurServiceImpl.updateOperateur(o);
//
//        // Assert
//        assertEquals("NouveauNom", updatedOperateur.getNom());
//    }
//
//
//    @Test
//    public void retrieveOperateurTest() {
//        // Arrange
//        Long id = 1L; // L'ID que vous souhaitez utiliser
//        Operateur operateur = new Operateur();
//        /////////  operateur.setNom("NomOpérateur");
//        operateurRepository.save(operateur);
//
//        // Act
//        Operateur result = operateurServiceImpl.retrieveOperateur(operateur.getIdOperateur());
//
//        // Assert
//        assertNotNull(result); // Vérifie que l'objet renvoyé n'est pas null
//        assertEquals(operateur.getIdOperateur(), result.getIdOperateur()); // Vérifie que les ID correspondent
//        assertEquals(operateur.getNom(), result.getNom());// Vérifie le Nom
//
//        ///////// assertEquals("NomOpérateur", result.getNom()); // Vérifie que le Nom correspond
//        // Ajoutez d'autres assertions pour vérifier d'autres propriétés si nécessaire
//
//
//
//    }
//





//}
