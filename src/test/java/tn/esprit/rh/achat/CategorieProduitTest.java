package tn.esprit.rh.achat;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class CategorieProduitTest {


    @Mock
    private CategorieProduitRepository categorieProduitRepository;
@InjectMocks
private CategorieProduitServiceImpl categorieProduitService;

public CategorieProduitTest(){}

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
     void testRetrieveAllCategorieProduits(){
        // Créez une liste de categorieProduit pour le test
    List<CategorieProduit> ListCategorieP = new ArrayList<>();
    ListCategorieP.add(new CategorieProduit("code1", "libelle1"));
        ListCategorieP.add(new CategorieProduit("code2", "libelle2"));
        // Définissez le comportement du mock repository
        when(categorieProduitRepository.findAll()).thenReturn(ListCategorieP);

        // Appelez la méthode du service que vous voulez tester
        List<CategorieProduit> retrievedList = categorieProduitService.retrieveAllCategorieProduits();

        // Vérifiez si la méthode du repository a été appelée
        verify(categorieProduitRepository, times(1)).findAll();
        // Vérifiez le résultat
        assertEquals(2, retrievedList.size());
        assertEquals("code1", retrievedList.get(0).getCodeCategorie());
        assertEquals("code2", retrievedList.get(1).getCodeCategorie());

    }


@Test
     void testAddCategorieProduit(){
    // Créez une categorieProduit pour le test
    CategorieProduit categorieProduit = new CategorieProduit("code3", "libelle3");
    // Définissez le comportement du mock repository
    when(categorieProduitRepository.save(categorieProduit)).thenReturn(categorieProduit);
    // Appelez la méthode du service que vous voulez tester
    CategorieProduit addedCategorieProduit = categorieProduitService.addCategorieProduit(categorieProduit);

    // Vérifiez si la méthode du repository a été appelée
    verify(categorieProduitRepository, times(1)).save(categorieProduit);
    // Vérifiez le résultat
    assertEquals("code3", addedCategorieProduit.getCodeCategorie());
    assertEquals("libelle3",addedCategorieProduit.getLibelleCategorie());
}

//@Test
   // void testDeleteCategorieProduit(){
  // long idCategorieProduit = 1;
 //  this.categorieProduitService.deleteCategorieProduit(idCategorieProduit);
 //  ((CategorieProduitRepository)Mockito.verify(this.categorieProduitRepository)).deleteById(idCategorieProduit);
//}










}
