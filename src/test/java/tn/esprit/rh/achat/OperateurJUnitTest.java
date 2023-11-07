package tn.esprit.rh.achat;


import nonapi.io.github.classgraph.concurrency.AutoCloseableExecutorService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest

@TestPropertySource(locations = "classpath:application.properties")
public class OperateurJUnitTest {

   @Autowired
     OperateurRepository operateurRepository;
    @Autowired
    OperateurServiceImpl operateurServiceImpl;

    @Test
    void testRetrieveAllOperateurs() {
        ArrayList<Operateur> operateurList = new ArrayList<>();
        operateurRepository.saveAll(operateurList);

        List<Operateur> actualRetrieveAllOperateursResult = operateurServiceImpl.retrieveAllOperateurs();

        assertNotSame(operateurList, actualRetrieveAllOperateursResult);
        assertFalse(actualRetrieveAllOperateursResult.isEmpty());
    }
    @Test
    void testAddOperateur() {

        Operateur newOperateur = new Operateur();
        newOperateur.setNom("karim");
        newOperateur.setPrenom("mejbri");
        newOperateur.setPassword("0");

        Operateur addedOperateur = operateurServiceImpl.addOperateur(newOperateur);

        assertNotNull(addedOperateur);

        Operateur retrievedOperateur = operateurRepository.findById(addedOperateur.getIdOperateur()).orElse(null);

        assertNotNull(retrievedOperateur);
        assertEquals("karim", retrievedOperateur.getNom());
        assertEquals("mejbri", retrievedOperateur.getPrenom());
        assertEquals("0", retrievedOperateur.getPassword());
    }

    @Test
    void testDeleteOperateur() {
        // Create a new Operateur object
        Operateur newOperateur = new Operateur();
        newOperateur.setNom("testoperature");

        // Save the Operateur using the repository
        Operateur addedOperateur = operateurRepository.save(newOperateur);

        // Call the method to delete the Operateur by its ID
        operateurServiceImpl.deleteOperateur(addedOperateur.getIdOperateur());

        // Try to retrieve the deleted Operateur from the repository
        Optional<Operateur> deletedOperateur = operateurRepository.findById(addedOperateur.getIdOperateur());

        // Assert that the deleted Operateur is not found
        assertFalse(deletedOperateur.isPresent());
    }


    @Test
    void testUpdateOperateur() {

        Operateur newOperateur = new Operateur();
        newOperateur.setNom("testoperature2");


        Operateur addedOperateur = operateurRepository.save(newOperateur);


        addedOperateur.setNom("updatedtestoperature2");


        Operateur updatedOperateur = operateurServiceImpl.updateOperateur(addedOperateur);


        Operateur retrievedOperateur = operateurRepository.findById(addedOperateur.getIdOperateur()).orElse(null);


        assertEquals("updatedtestoperature2", retrievedOperateur.getNom());
    }
    @Test
    void testRetrieveOperateur() {

        Operateur newOperateur = new Operateur();
        newOperateur.setNom("test3");
        newOperateur.setPrenom("test3p");
        newOperateur.setPassword("12345");


        Operateur addedOperateur = operateurServiceImpl.addOperateur(newOperateur);


        Operateur retrievedOperateur = operateurServiceImpl.retrieveOperateur(addedOperateur.getIdOperateur());


        assertNotNull(retrievedOperateur);


        assertEquals("test3", retrievedOperateur.getNom());
        assertEquals("test3p", retrievedOperateur.getPrenom());
        assertEquals("12345", retrievedOperateur.getPassword());
    }


}
