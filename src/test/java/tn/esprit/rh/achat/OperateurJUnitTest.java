package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest


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
        newOperateur.setNom("abir1");
        newOperateur.setPrenom("mekki1");
        newOperateur.setPassword("1");

        Operateur addedOperateur = operateurServiceImpl.addOperateur(newOperateur);

        assertNotNull(addedOperateur);

        Operateur retrievedOperateur = operateurRepository.findById(addedOperateur.getIdOperateur()).orElse(null);

        assertNotNull(retrievedOperateur);
        assertEquals("abir1", retrievedOperateur.getNom());
        assertEquals("mekki1", retrievedOperateur.getPrenom());
        assertEquals("1", retrievedOperateur.getPassword());
    }

    @Test
    void testDeleteOperateur() {
        // Create a new Operateur object
        Operateur newOperateur = new Operateur();
        newOperateur.setNom("abir2");
        newOperateur.setPrenom("mekki2");
        newOperateur.setPassword("2");

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
        newOperateur.setNom("abir3");
        newOperateur.setPrenom("mekki3");
        newOperateur.setPassword("3");

        Operateur addedOperateur = operateurRepository.save(newOperateur);

        addedOperateur.setNom("abir3");

        Operateur updatedOperateur = operateurServiceImpl.updateOperateur(addedOperateur);

        Operateur retrievedOperateur = operateurRepository.findById(addedOperateur.getIdOperateur()).orElse(null);

        assertEquals("abir3", retrievedOperateur.getNom());
        assertEquals("mekki3", retrievedOperateur.getPrenom());
    }
    @Test
    void testRetrieveOperateur() {

        Operateur newOperateur = new Operateur();
        newOperateur.setNom("abir4");
        newOperateur.setPrenom("mekki4");
        newOperateur.setPassword("4");

        Operateur addedOperateur = operateurServiceImpl.addOperateur(newOperateur);

        Operateur retrievedOperateur = operateurServiceImpl.retrieveOperateur(addedOperateur.getIdOperateur());

        assertNotNull(retrievedOperateur);

        assertEquals("abir4", retrievedOperateur.getNom());
        assertEquals("mekki4", retrievedOperateur.getPrenom());
        assertEquals("4", retrievedOperateur.getPassword());
    }


}