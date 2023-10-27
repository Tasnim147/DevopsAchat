package tn.esprit.rh.achat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {OperateurServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class OperateurTest_Mokito {


    @InjectMocks
    private OperateurServiceImpl operateurServiceImpl;

    @Mock
    private OperateurRepository operateurRepository;


    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAllOperateursTest() {
        // Arrange
        List<Operateur> operateurList = new ArrayList<>();
        when(operateurRepository.findAll()).thenReturn(operateurList);

        // Act
        List<Operateur> result = operateurServiceImpl.retrieveAllOperateurs();

        // Assert
        assertEquals(operateurList, result);
    }
    @Test
    public void addOperateurTest() {
        // Arrange
        Operateur o = new Operateur();
        when(operateurRepository.save(o)).thenReturn(o);

        // Act
        Operateur result = operateurServiceImpl.addOperateur(o);

        // Assert
        assertEquals(o, result);
    }

    @Test
    public void deleteOperateurTest() {
        // Arrange
        Long id = 1L;

        // Act
        operateurServiceImpl.deleteOperateur(id);

        // Assert
        verify(operateurRepository).deleteById(id);
    }
    @Test
    public void updateOperateurTest() {
        // Arrange
        Operateur op = new Operateur();
        when(operateurRepository.save(op)).thenReturn(op);

        // Act
        Operateur result = operateurServiceImpl.updateOperateur(op);

        // Assert
        assertEquals(op, result);
    }
    @Test
    public void retrieveOperateurTest() {
        // Arrange
        Long id = 1L;
        Operateur operateur = new Operateur();
        when(operateurRepository.findById(id)).thenReturn(Optional.of(operateur));

        // Act
        Operateur result = operateurServiceImpl.retrieveOperateur(id);

        // Assert
        assertEquals(operateur, result);
    }

}