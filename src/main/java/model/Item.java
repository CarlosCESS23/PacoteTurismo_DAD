package model;

import jakarta.persistence.*;
import utils.ItemServico;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity()
@Table(name = "Item")
public class Item implements Serializable {

    private final long serialVersionUID = 1l;

    @Column(name="itemId",unique = true,nullable = false)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long ItemId;

    @Column(name = "itemValor",unique = false,nullable = false)
    private double itemValor;

    @Column(name = "itemTipo",unique = false,nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ItemServico itemTipo;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "pac_id",
            nullable = false
    )
    private PacoteTurismo pacoteTurismo;

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

    public void setPacote(PacoteTurismo pacoteTurismo){
        this.pacoteTurismo = pacoteTurismo;
    }

    @Override
    public String toString() {
        return "\nItem{" +
                "itemTipo=" + itemTipo +
                ", itemValor=" + itemValor +
                '}';
    }
}
