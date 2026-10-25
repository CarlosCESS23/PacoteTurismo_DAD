package model;

import utils.ItemServico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacoteTurismo implements Serializable {
    private final long serialVersionUID = 1l;

    private int pacId;
    private String pacOrigem;
    private String pacDestino;
    private List<Item> pacItens;
    private boolean pacDesconto;
    private int pacPessoa;
    private double pacValorTotal;

    public PacoteTurismo(int pacId, String pacOrigem, String pacDestino,int pacPessoa) {
        this.pacId = pacId;
        this.pacOrigem = pacOrigem;
        this.pacDestino = pacDestino;
        this.pacPessoa = pacPessoa;
        this.pacItens = new ArrayList<>();
    }

    public void addItem(Item itemSelecionado){
        this.pacItens.add(itemSelecionado);
    }

    public void rmItem(Item itemSelecionado){
        this.pacItens.remove(itemSelecionado);
    }

    public PacoteTurismo(){

    }

    public List<Item> ListarTipos(ItemServico tipo) {
        List<Item> listaSelecionado = this.pacItens.stream()
                .filter(lista -> lista.getTipo() == tipo)
                .collect(Collectors.toList());

        return listaSelecionado;
    }

    @Override
    public String toString() {
        return "PacoteTurismo{" +
                ", pacId=" + pacId +
                ", pacOrigem='" + pacOrigem + '\'' +
                ", pacDestino='" + pacDestino + '\'' +
                ", pacItens=" + pacItens +
                ", pacDesconto=" + pacDesconto +
                ", pacPessoa=" + pacPessoa +
                ", pacValorTotal=" + pacValorTotal +
                '}';
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPacId() {
        return pacId;
    }

    public String getPacOrigem() {
        return pacOrigem;
    }

    public String getPacDestino() {
        return pacDestino;
    }

    public List<Item> getPacItens() {
        return pacItens;
    }

    public boolean isPacDesconto() {
        return pacDesconto;
    }

    public int getPacPessoa() {
        return pacPessoa;
    }

    public double getPacValorTotal() {
        return pacValorTotal;
    }

    public void elegerDesconto(Boolean desconto){
        this.pacDesconto = desconto;
    }
}
