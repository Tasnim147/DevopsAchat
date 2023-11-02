package tn.esprit.rh.achat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategorieProduitTest {

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private CategorieProduitServiceImpl categorieProduitService;

    @Test
    public void testRetrieveAllCategorieProduits() {
        // creer liste de categorieProduit
        CategorieProduit categorie1 = new CategorieProduit("code1", "Libelle 1");
        CategorieProduit categorie2 = new CategorieProduit("code2", "Libelle 2");
        List<CategorieProduit> categorieList = Arrays.asList(categorie1, categorie2);
//definissez le comportement du mock repo
        when(categorieProduitRepository.findAll()).thenReturn(categorieList);

        // Call the service method
        List<CategorieProduit> result = categorieProduitService.retrieveAllCategorieProduits();

        // Verify the service method and its outcome
        verify(categorieProduitRepository, times(1)).findAll();
       //verifier le resultat
        assertEquals(2, result.size());
    }

    @Test
    public void testAddCategorieProduit() {
        //creer une categorie
        CategorieProduit categorie = new CategorieProduit("code3", "Libelle 3");

        when(categorieProduitRepository.save(categorie)).thenReturn(categorie);
//appeler la methode a tester
        CategorieProduit result = categorieProduitService.addCategorieProduit(categorie);
//verifier si la methode a ete appelee
        verify(categorieProduitRepository, times(1)).save(categorie);
    //verifier le resultat
        assertEquals(categorie, result);
    }

}
