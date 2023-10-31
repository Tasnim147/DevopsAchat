package tn.esprit.rh.achat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {OperateurServiceImpl.class})
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class OperateurMokitoTest {


    //@InjectMocks
    private OperateurServiceImpl operateurServiceImpl;
//    @Mock
     private OperateurRepository operateurRepository;

//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    public void retrieveAllOperateursTest() {
        // Arrange
        Operateur operateur1 = new Operateur();
        Operateur operateur2 = new Operateur();
          long id2 = 123;
        long id1 = 11;
        operateurRepository = mock(OperateurRepository.class);
        operateurServiceImpl = new OperateurServiceImpl(operateurRepository);
        List<Operateur> opList = new ArrayList<>();
        opList.add(new Operateur(id1,"aaaa","azerty","a100"));
        opList.add(new Operateur(id2,"vest","zzzz","50"));
        when(operateurRepository.findAll()).thenReturn(opList);

//        when(operateurRepository.findAll()).thenReturn(Arrays.asList(operateur1, operateur2));
//
//        // Act
//        List<Operateur> result = operateurServiceImpl.retrieveAllOperateurs();
//
//        // Assert
//        assertNotNull(result); // Vérifie que la liste renvoyée n'est pas nulle
//        assertEquals(2, result.size()); // Vérifie que la liste contient deux opérateurs (ou le nombre attendu)
//        assertTrue(result.contains(operateur1)); // Vérifie que operateur1 est dans la liste
//        assertTrue(result.contains(operateur2)); // Vérifie que operateur2 est dans la liste
//
//        // Vérifie que la méthode operateurRepository.findAll() a bien été appelée
//        verify(operateurRepository).findAll();
    }

//    @Test
//    public void addOperateurTest() {
//        // Arrange
//        Operateur operateur = new Operateur();
//        when(operateurRepository.save(operateur)).thenReturn(operateur);
//
//        // Act
//        Operateur result = operateurServiceImpl.addOperateur(operateur);
//
//        // Assert
//        assertNotNull(result); // Vérifie que l'opérateur retourné n'est pas nul
//        assertEquals(operateur, result); // Vérifie que l'opérateur retourné est le même que celui que vous avez passé
//
//        // Vérifie que la méthode operateurRepository.save() a bien été appelée avec l'opérateur en argument
//        verify(operateurRepository).save(operateur);
//    }
//    @Test
//   public void testAddOperateur() {
//    Operateur operateur = new Operateur();
//    operateur.setNom("test");
//
//    Mockito.when(operateurRepository.save(operateur)).thenReturn(operateur);
//
//    Operateur result = operateurServiceImpl.addOperateur(operateur);
//
//    assertNotNull(result);
//    assertEquals("test", result.getNom());
//}

//    @Test
//    public void testDeleteOperateur() {
//
//        Long operateurIdToDelete = 1L;
//
//        operateurServiceImpl.deleteOperateur(operateurIdToDelete);
//
//        Mockito.verify(operateurRepository).deleteById(operateurIdToDelete); //verifier l'appel de la fonction
//    }

//    @Test
//    public void deleteOperateurTest() {
//        // Arrange
//        Operateur operateur = new Operateur();
//        when(operateurRepository.findById(operateur.getIdOperateur())).thenReturn(Optional.of(operateur));
//
//        // Act
//        operateurServiceImpl.deleteOperateur(operateur.getIdOperateur());
//
//        // Assert
//        Optional<Operateur> deletedOperateur = operateurRepository.findById(operateur.getIdOperateur());
//        assertFalse(deletedOperateur.isPresent()); // Vérifie que l'opérateur a été supprimé (résultat vide)
//
//        // Vérifie que la méthode operateurRepository.findById() a bien été appelée avec l'ID en argument
//        verify(operateurRepository).findById(operateur.getIdOperateur());
//
//        // Vérifie que la méthode operateurRepository.deleteById() a bien été appelée avec l'ID en argument
//        verify(operateurRepository).deleteById(operateur.getIdOperateur());
//    }

//    @Test
//    public void updateOperateurTest() {
//        // Arrange
//        Operateur o = new Operateur();
//        when(operateurRepository.save(o)).thenReturn(o);
//
//        // Modification simulée de l'objet
//        o.setNom("NouveauNom");
//        // Ajoutez d'autres modifications si nécessaire...
//
//        // Act
//        Operateur updatedOperateur = operateurServiceImpl.updateOperateur(o);
//
//        // Assert
//        assertEquals("NouveauNom", updatedOperateur.getNom());
//
//        // Vérifie que la méthode operateurRepository.save() a bien été appelée avec l'opérateur en argument
//        verify(operateurRepository).save(o);
//    }

//    @Test
//    public void retrieveOperateurTest() {
//
//        // Arrange
//        Long idOperateur = 1L;
//        Operateur operateur = new Operateur();
//        when(operateurRepository.findById(operateur.getIdOperateur())).thenReturn(Optional.of(operateur));
//
//        // Act
//        Operateur result = operateurServiceImpl.retrieveOperateur(operateur.getIdOperateur());
//
//        // Assert
//        assertNotNull(result); // Vérifie que l'objet renvoyé n'est pas nul
//        assertEquals(operateur.getIdOperateur(), result.getIdOperateur()); // Vérifie que les ID correspondent
//        // Ajoutez d'autres assertions pour vérifier d'autres propriétés si nécessaire
//
//        // Vérifie que la méthode operateurRepository.findById() a bien été appelée avec l'ID en argument
//        verify(operateurRepository).findById(operateur.getIdOperateur());
//    }

}