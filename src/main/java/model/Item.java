package model;

import utils.ItemServico;

import java.io.Serializable;
public class Item implements Serializable {
    private final long serialVersionUID = 1l;
    private double itemValor;
    private ItemServico itemTipo;

    public Item(double itemValor, ItemServico itemTipo) {
        this.itemValor = itemValor;
        this.itemTipo = itemTipo;
    }

    public Item() {

    }

    public double getValor() {
        return itemValor;
    }

    public void setValor(double itemValor) {
        this.itemValor = itemValor;
    }

    public ItemServico getTipo() {
        return itemTipo;
    }

    public void setTipo(ItemServico itemTipo) {
        this.itemTipo = itemTipo;
    }

    @Override
    public String toString() {
        return "\nItem{" +
                "itemTipo=" + itemTipo +
                ", itemValor=" + itemValor +
                '}';
    }
}
