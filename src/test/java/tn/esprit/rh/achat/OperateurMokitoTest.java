package tn.esprit.rh.achat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.*;

@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {OperateurServiceImpl.class})


public class OperateurMokitoTest {


    private OperateurServiceImpl operateurServiceImpl;

     private OperateurRepository operateurRepository;
    @Test
    public void addOperateurTest() {

    long id1 = 11;
    Operateur newOperateur = new Operateur(id1, "aaaa", "azerty", "a100");

    operateurRepository = mock(OperateurRepository.class);
    operateurServiceImpl = new OperateurServiceImpl(operateurRepository);

    when(operateurRepository.save(newOperateur)).thenReturn(newOperateur);

}

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
        opList.add(new Operateur(id1, "aaaa", "azerty", "a100"));
        opList.add(new Operateur(id2, "vest", "zzzz", "50"));
        when(operateurRepository.findAll()).thenReturn(opList);
    }
    @Test
    public void retrieveOperateurByIdTest() {
        // Arrange
        Operateur op1 = new Operateur(11, "aaaa", "azerty", "a100");
        Operateur op2 = new Operateur(123, "vest", "zzzz", "50");
        long idToRetrieve = 11;

        operateurRepository = mock(OperateurRepository.class);
        operateurServiceImpl = new OperateurServiceImpl(operateurRepository);

        when(operateurRepository.findById(idToRetrieve)).thenReturn(Optional.of(op1));


    }

}