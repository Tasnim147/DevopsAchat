package tn.esprit.rh.achat;


import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
 class CategorieProduitTest {


    @Mock
    private CategorieProduitRepository categorieProduitRepository;
@InjectMocks
private CategorieProduitServiceImpl categorieProduitService;

public CategorieProduitTest(){}

    @BeforeEach
     void setup() {
        MockitoAnnotations.initMocks(this);}
    @Test
     void testRetrieveAllCategorieProduits(){
    List<CategorieProduit> ListCategorieP = new ArrayList<>();
    ListCategorieP.add(new CategorieProduit("code1", "libelle1"));
        ListCategorieP.add(new CategorieProduit("code2", "libelle2"));
        Mockito.when(this.categorieProduitRepository.findAll()).thenReturn(ListCategorieP);
        List<CategorieProduit> retrievedList = this.categorieProduitService.retrieveAllCategorieProduits();
        ((CategorieProduitRepository)Mockito.verify(this.categorieProduitRepository, Mockito.times(1))).findAll();
        Assertions.assertEquals(2,retrievedList.size());
        Assertions.assertEquals("code1",((CategorieProduit)retrievedList.get(0)).getCodeCategorie());
        Assertions.assertEquals("code2",((CategorieProduit)retrievedList.get(1)).getCodeCategorie());}


@Test
     void testAddCategorieProduit(){
    CategorieProduit categorieProduit = new CategorieProduit("code3", "libelle3");
    Mockito.when(this.categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);
    CategorieProduit addedCategorieProduit = this.categorieProduitService.addCategorieProduit(categorieProduit);
    ((CategorieProduitRepository)Mockito.verify(this.categorieProduitRepository, Mockito.times(1))).save(categorieProduit);
    Assertions.assertEquals("code3", addedCategorieProduit.getCodeCategorie());
    Assertions.assertEquals("libelle3",addedCategorieProduit.getLibelleCategorie());
}

@Test
    void testDeleteCategorieProduit(){
   long idCategorieProduit = 1;
   this.categorieProduitService.deleteCategorieProduit(idCategorieProduit);
   ((CategorieProduitRepository)Mockito.verify(this.categorieProduitRepository)).deleteById(idCategorieProduit);
}










}
