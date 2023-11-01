package tn.esprit.rh.achat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class Stocktest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        // Créez une liste de stocks factices pour le test
        List<Stock> fakeStocks = new ArrayList<>();
        fakeStocks.add(new Stock("Stock 1", 100, 10));
        fakeStocks.add(new Stock("Stock 2", 200, 20));

        // Définissez le comportement du mock repository
        when(stockRepository.findAll()).thenReturn(fakeStocks);

        // Appelez la méthode du service que vous voulez tester
        List<Stock> retrievedStocks = stockService.retrieveAllStocks();

        // Vérifiez si la méthode du repository a été appelée
        verify(stockRepository, times(1)).findAll();

        // Vérifiez le résultat
        assertEquals(2, retrievedStocks.size());
        assertEquals("Stock 1", retrievedStocks.get(0).getLibelleStock());
        assertEquals("Stock 2", retrievedStocks.get(1).getLibelleStock());
    }

    @Test
    public void testAddStock() {
        // Créez un stock factice pour le test
        Stock fakeStock = new Stock("Nouveau Stock", 150, 15);

        // Définissez le comportement du mock repository
        when(stockRepository.save(fakeStock)).thenReturn(fakeStock);

        // Appelez la méthode du service que vous voulez tester
        Stock addedStock = stockService.addStock(fakeStock);

        // Vérifiez si la méthode du repository a été appelée
        verify(stockRepository, times(1)).save(fakeStock);

        // Vérifiez le résultat
        assertEquals("Nouveau Stock", addedStock.getLibelleStock());
        assertEquals(150, addedStock.getQte());
        assertEquals(15, addedStock.getQteMin());
    }

    // Écrivez des tests similaires pour les autres méthodes du service.

    // ... (tests pour d'autres méthodes)

    @Test
    public void testDeleteStock() {
        Long stockIdToDelete = 1L;
        stockService.deleteStock(stockIdToDelete);
        verify(stockRepository).deleteById(stockIdToDelete);
    }

    @Test
    public void testUpdateStock() {
        Stock stockToUpdate = new Stock(1L, "UpdatedStock", 150, 15);
        when(stockRepository.save(stockToUpdate)).thenReturn(stockToUpdate);
        Stock result = stockService.updateStock(stockToUpdate);
        assertEquals(stockToUpdate, result);
    }

    @Test
    public void testRetrieveStock() {
        Long stockIdToRetrieve = 1L;
        Stock expectedStock = new Stock(stockIdToRetrieve, "RetrievedStock", 100, 10);
        when(stockRepository.findById(stockIdToRetrieve)).thenReturn(java.util.Optional.ofNullable(expectedStock));
        Stock result = stockService.retrieveStock(stockIdToRetrieve);
        assertEquals(expectedStock, result);
    }
}
