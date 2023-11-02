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
        // Mocking data
        CategorieProduit categorie1 = new CategorieProduit("code1", "Libelle 1");
        CategorieProduit categorie2 = new CategorieProduit("code2", "Libelle 2");
        List<CategorieProduit> categorieList = Arrays.asList(categorie1, categorie2);

        when(categorieProduitRepository.findAll()).thenReturn(categorieList);

        // Call the service method
        List<CategorieProduit> result = categorieProduitService.retrieveAllCategorieProduits();

        // Verify the service method and its outcome
        verify(categorieProduitRepository, times(1)).findAll();
        assertEquals(2, result.size());
    }
}
