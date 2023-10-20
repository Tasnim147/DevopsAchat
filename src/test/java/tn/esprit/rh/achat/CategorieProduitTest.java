package tn.esprit.rh.achat;


import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = {CategorieProduitServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class CategorieProduitTest {


    @MockBean
    private ProduitRepository produitRepository;

    @MockBean
    private CategorieProduitRepository categorieProduitRepository;

    @Autowired
    private CategorieProduitServiceImpl categorieProduitServiceImpl;

    @Test
    void testRetrieveAllCategorieProduits(){
        ArrayList<CategorieProduit> categorieProduitList = new ArrayList<>();
        when(categorieProduitRepository.findAll()).thenReturn(categorieProduitList);
        List<CategorieProduit> actualRetrieveAllCategorieResult = categorieProduitServiceImpl.retrieveAllCategorieProduits();
        assertSame(categorieProduitList, actualRetrieveAllCategorieResult);
        assertTrue(actualRetrieveAllCategorieResult.isEmpty());
        verify(categorieProduitRepository).findAll();

    }

    @Test
    void testDeleteCategorieProduits(){
        doNothing().when(categorieProduitRepository).deleteById((Long) any());
        categorieProduitServiceImpl.deleteCategorieProduit(123L);
        verify(categorieProduitRepository).deleteById((Long) any());

    }

}
