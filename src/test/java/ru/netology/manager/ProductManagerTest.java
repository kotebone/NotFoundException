package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(1, "Бедные люди", 249, "Ф.М.Достоевский");
    Book book2 = new Book(2, "Собачье сердце", 339, "М.А. Булгаков");
    Book book3 = new Book(3, "Zarathustra", 189, "Ф.М.Ницше");
    Smartphone smartphone1 = new Smartphone(4, "iPhone 12", 69990, "Apple");
    Smartphone smartphone2 = new Smartphone(5, "Galaxy S20", 45990, "Samsung");
    Smartphone smartphone3 = new Smartphone(6, "Redmi Note 10S", 19900, "Xiaomi");

    @Test
    public void searchManyProducts() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        assertArrayEquals(new Product[]{smartphone2,smartphone3}, productManager.searchBy("S"));
    }

    @Test
    public void shouldFindBookByAuthor (){
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        assertArrayEquals(new Product[]{book1}, productManager.searchBy("Достоевский"));
    }


    @Test
    public void findBookByName(){
        productManager.add(book2);

        assertArrayEquals(new Product[] {book2}, productManager.searchBy("Собачье сердце"));
    }

    @Test
    public void findSmartphoneByProducer(){
        productManager.add(smartphone1);

        assertArrayEquals(new Product[] {smartphone1}, productManager.searchBy("Apple") );
    }

    @Test
    public void findSmartphoneByName(){
        productManager.add(smartphone2);

        assertArrayEquals(new Product[] {smartphone2}, productManager.searchBy("Galaxy") );
    }

    @Test
    public void findNot(){
        productManager.add(smartphone2);

        assertArrayEquals(new Product[]{}, productManager.searchBy("10S") );
    }
}