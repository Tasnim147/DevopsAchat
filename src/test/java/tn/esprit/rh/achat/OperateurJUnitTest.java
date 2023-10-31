package tn.esprit.rh.achat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;



import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest

public class OperateurJUnitTest {

//   @Autowired
//     OperateurRepository operateurRepository;
//    @Autowired
//     OperateurServiceImpl operateurServiceImpl;
//
//
//  @Test
//    public void addOperateurTest() {
//        // Arrange
//        Operateur operateur = new Operateur();
//      operateur.setNom("abir");
////        // Act
//       Operateur result = operateurServiceImpl.addOperateur(operateur);
////
////        // Assert
//       assertNotNull(result); // Vérifie que l'opérateur retourné n'est pas nul
//       assertEquals(operateur, result); // Vérifie que l'opérateur retourné est le même que celui que vous avez passé
//       }
//
//   @Test
// public void retrieveOperateurTest() {
////        // Arrange
//    Long id = 1L; // L'ID que vous souhaitez utiliser
//     Operateur operateur = new Operateur();
////        /////////  operateur.setNom("NomOpérateur");
//        operateurRepository.save(operateur);
////
////        // Act
//        Operateur result = operateurServiceImpl.retrieveOperateur(operateur.getIdOperateur());
////
////        // Assert
//      assertNotNull(result); // Vérifie que l'objet renvoyé n'est pas null
//       assertEquals(operateur.getIdOperateur(), result.getIdOperateur()); // Vérifie que les ID correspondent
//       assertEquals(operateur.getNom(), result.getNom());// Vérifie le Nom
////
////        ///////// assertEquals("NomOpérateur", result.getNom()); // Vérifie que le Nom correspond
////        // Ajoutez d'autres assertions pour vérifier d'autres propriétés si nécessaire
//
//
//  }
//
//
//
//


}
