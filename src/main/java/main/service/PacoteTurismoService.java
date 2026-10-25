package main.service;

import main.exception.RunTimeExceptionDuplicationById;
import main.exception.RunTimeExceptionSearchGetByIdNotExist;
import model.Item;
import model.PacoteTurismo;
import org.springframework.stereotype.Service;
import utils.ItemServico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PacoteTurismoService implements IPacoteTurismoService {
    List<PacoteTurismo> pacoteTurismos;

    public PacoteTurismoService(){
          pacoteTurismos = new ArrayList<>(inicializarPacote());
    }

    private List<PacoteTurismo> inicializarPacote(){

        // Pacote 1 - Manaus para Fortaleza
        var pacoteTurismo1 = new PacoteTurismo(1, "MAO", "FOR", 3);
        pacoteTurismo1.addItem(new Item(1500.00, ItemServico.AEREO));
        pacoteTurismo1.addItem(new Item(850.00, ItemServico.HOTEL));
        pacoteTurismo1.addItem(new Item(120.00, ItemServico.SEGURO));

        // Pacote 2 - Manaus para Belém
        var pacoteTurismo2 = new PacoteTurismo(2, "MAO", "BEL", 2);
        pacoteTurismo2.addItem(new Item(900.00, ItemServico.AEREO));
        pacoteTurismo2.addItem(new Item(450.00, ItemServico.HOTEL));

        // Pacote 3 - Manaus para Brasília
        var pacoteTurismo3 = new PacoteTurismo(3, "MAO", "BSB", 4);
        pacoteTurismo3.addItem(new Item(1800.00, ItemServico.AEREO));
        pacoteTurismo3.addItem(new Item(950.00, ItemServico.HOTEL));
        pacoteTurismo3.addItem(new Item(300.00, ItemServico.CARRO));

        // Pacote 4 - Fortaleza para Manaus
        var pacoteTurismo4 = new PacoteTurismo(4, "FOR", "MAO", 1);
        pacoteTurismo4.addItem(new Item(1300.00, ItemServico.AEREO));
        pacoteTurismo4.addItem(new Item(200.00, ItemServico.CARRO));

        // Pacote 5 - Belém para Manaus
        var pacoteTurismo5 = new PacoteTurismo(5, "BEL", "MAO", 5);
        pacoteTurismo5.addItem(new Item(1100.00, ItemServico.AEREO));
        pacoteTurismo5.addItem(new Item(700.00, ItemServico.HOTEL));
        pacoteTurismo5.addItem(new Item(150.00, ItemServico.SEGURO));

        return List.of(
                pacoteTurismo1,
                pacoteTurismo2,
                pacoteTurismo3,
                pacoteTurismo4,
                pacoteTurismo5
        );
    }

    public PacoteTurismo getByIdPacoteTurismo(int id){
        Optional<PacoteTurismo> pacoteSelecionado = this.pacoteTurismos.stream()
                .filter(pacoteTurismo -> pacoteTurismo.getPacId() == id)
                .findFirst();

        if(pacoteSelecionado.isEmpty()){
            throw new RunTimeExceptionSearchGetByIdNotExist("Não foi possível encontrar o ID do usuário");
        }

        return pacoteSelecionado.get();

    }

    public PacoteTurismo deleteByIdPacoteTurismo(int id){
        Optional<PacoteTurismo> pacoteSelecionado = this.pacoteTurismos.stream()
                .filter(pacoteTurismo -> pacoteTurismo.getPacId() == id)
                .findFirst();
        if(pacoteSelecionado.isEmpty()){
            throw new RunTimeExceptionSearchGetByIdNotExist("Não foi possível encontrar o ID, talvez tenha sido removido");
        }
        this.pacoteTurismos.remove(pacoteSelecionado.get());
        return pacoteSelecionado.get();
    }

    @Override
    public PacoteTurismo postPacoteTurismo(PacoteTurismo pacote) {
        var lista_atualizada = this.pacoteTurismos;

        boolean verificar_duplicidade = this.pacoteTurismos.stream()
                .anyMatch(pacotes -> pacotes.getPacId() == pacote.getPacId());

        if(verificar_duplicidade){
           throw new RunTimeExceptionDuplicationById("Existe ID já inscrito, tente com outro ID");
        }
        lista_atualizada.add(pacote);
        lista_atualizada.sort(Comparator.comparingInt(PacoteTurismo::getPacId));
        return pacote;
    }

    public List<PacoteTurismo> getAllPacote(){
        return pacoteTurismos;
    }



}
