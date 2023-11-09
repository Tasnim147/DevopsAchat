package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class OperateurMokitoTest {

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Mock
    private OperateurRepository operateurRepository;



    @Test
    public void testRetrieveAllOperateurs() {
        List<Operateur> operateurList = new ArrayList<>();
        operateurList.add(new Operateur());
        operateurList.add(new Operateur());
        operateurList.add(new Operateur());
        operateurList.add(new Operateur());

        when(operateurRepository.findAll()).thenReturn(operateurList);

        List<Operateur> result = operateurService.retrieveAllOperateurs();

        assertEquals(4, result.size());
    }

    @Test
    public void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("sahar1");
        operateur.setPrenom("BJ1");
        operateur.setPassword("0");
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur result = operateurService.addOperateur(operateur);

        assertEquals(operateur, result);
        assertEquals("sahar1", result.getNom());
        assertEquals("BJ1", result.getPrenom());
        assertEquals("0", result.getPassword());
    }

    @Test
    public void testDeleteOperateur() {
        Long IdToDelete = 1L;

        operateurService.deleteOperateur(IdToDelete);

        verify(operateurRepository).deleteById(IdToDelete);
    }

    @Test
    public void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L);
        operateur.setNom("sahar2");
        operateur.setPrenom("BJ2");
        operateur.setPassword("00");

        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur result = operateurService.updateOperateur(operateur);

        assertNotNull(result);
        assertEquals("sahar2", result.getNom());
        assertEquals("BJ2", result.getPrenom());
        assertEquals("00", result.getPassword());
    }
    @Test
    public void testRetrieveOperateur() {
        Long id = 1L;

        Operateur operateur = new Operateur();
        operateur.setIdOperateur(1L);
        operateur.setNom("sahar3");
        operateur.setPrenom("BJ3");
        operateur.setPassword("000");

        when(operateurRepository.findById(id)).thenReturn(java.util.Optional.of(operateur));

        Operateur result = operateurService.retrieveOperateur(id);

        assertEquals(operateur, result);

        assertEquals("sahar3", result.getNom());
        assertEquals("BJ3", result.getPrenom());
        assertEquals("000", result.getPassword());
    }
}