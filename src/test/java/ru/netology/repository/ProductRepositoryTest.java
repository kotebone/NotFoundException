package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
  private final ProductRepository repository = new ProductRepository();
  private final Book coreJava = new Book();
  Book book1 = new Book(1, "Бедные люди", 249, "Ф.М.Достоевский");
  Book book2 = new Book(2, "Собачье сердце", 339, "М.А. Булгаков");
  Book book3 = new Book(3, "Zarathustra", 189, "Ф.М.Ницше");

  @Test
  public void shouldSaveOneItem() {
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldDeleteAnExistingElement(){
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void notFound(){
    repository.save(coreJava);
    repository.save(book1);
    int id = 7;

    assertThrows(NotFoundException.class, () -> repository.removeById(7), "Element with id: " + id + " not found");
  }
}