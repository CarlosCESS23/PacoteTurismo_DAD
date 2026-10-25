package main.service;

import model.PacoteTurismo;

import java.util.List;

public interface IPacoteTurismoService{
    public List<PacoteTurismo> getAllPacote();
    public PacoteTurismo getByIdPacoteTurismo(int id);
    public PacoteTurismo postPacoteTurismo(PacoteTurismo pacote);
    public PacoteTurismo deleteByIdPacoteTurismo(int id);
}
