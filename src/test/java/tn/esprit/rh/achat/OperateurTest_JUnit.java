package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class OperateurTest_JUnit {

    @Autowired
    private OperateurRepository operateurRepository;

    private OperateurServiceImpl operateurServiceImpl;

    @BeforeEach
    public void setUp() {
        operateurServiceImpl = new OperateurServiceImpl(operateurRepository);
    }

    @Test
    public void retrieveAllOperateursTest() {
        // Arrange
        Operateur operateur1 = new Operateur();
        Operateur operateur2 = new Operateur();
        operateurRepository.save(operateur1);
        operateurRepository.save(operateur2);

        // Act
        List<Operateur> result = operateurServiceImpl.retrieveAllOperateurs();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void addOperateurTest() {
        // Arrange
        Operateur operateur = new Operateur();

        // Act
        Operateur result = operateurServiceImpl.addOperateur(operateur);

        // Assert
        assertEquals(operateur, result);
    }
    @Test
    public void deleteOperateurTest() {
        // Arrange
        Operateur operateur = new Operateur();
        operateurRepository.save(operateur);

        // Act
        operateurServiceImpl.deleteOperateur(operateur.getIdOperateur());

        // Assert
        Optional<Operateur> deletedOperateur = operateurRepository.findById(operateur.getIdOperateur());
        assertEquals(Optional.empty(), deletedOperateur);
    }

    @Test
    public void updateOperateurTest() {
        // Arrange
        Operateur operateur = new Operateur();
        operateurRepository.save(operateur);

        // Act
        Operateur updatedOperateur = operateurServiceImpl.updateOperateur(operateur);

        // Assert
        assertEquals(operateur, updatedOperateur);
    }
    @Test
    public void retrieveOperateurTest() {
        // Arrange
        Operateur operateur = new Operateur();
        operateurRepository.save(operateur);

        // Act
        Operateur result = operateurServiceImpl.retrieveOperateur(operateur.getIdOperateur());

        // Assert
        assertEquals(operateur, result);
    }




}
