package ru.nethology.repository;

import ru.nethology.domain.NotFoundException;
import ru.nethology.domain.Product;

import java.util.Arrays;

public class ProductRepository {
  private Product[] items = new Product[0];

  public void save(Product item) {
    int length = items.length + 1;
    Product[] tmp = new Product[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Product[] findAll() {
    return items;
  }

  public Product findById(int id) {
    for (Product item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public void removeById(int id) {
        if(findById(id) == null){
      throw new NotFoundException("Element with id: " + id + " not found");

    }
    int length = items.length - 1;
    Product[] tmp = new Product[length];
    int index = 0;
    for (Product item : items) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    items = tmp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductRepository that = (ProductRepository) o;
    return Arrays.equals(items, that.items);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(items);
  }

  @Override
  public String toString() {
    return "ProductRepository{" +
            "items=" + Arrays.toString(items) +
            '}';
  }
}
