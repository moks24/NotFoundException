package ru.nethology.repository;

import org.junit.jupiter.api.Test;
import ru.nethology.domain.NotFoundException;
import ru.nethology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product first = new Product(1, "Java I", 900);
    Product second = new Product(2, "Java 2", 100);
    Product third = new Product(3, "Java 3", 1500);

    @Test
    public void shouldRemoveItem(){
        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(2);

        Product[] expected = new Product[]{first, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotFoundException() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        assertThrows(NotFoundException.class,() ->{
            repository.removeById(4);
        });

    }
}