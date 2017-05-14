package org.cba.domain;

import org.cba.domain.finder.AssemblyMaterialFinder;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by adam on 03/05/2017.
 */
@Entity
public class AssemblyMaterial {

  public static final AssemblyMaterialFinder find = new AssemblyMaterialFinder();
    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    private int price;

    @NotNull
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}