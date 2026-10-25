package main.controller;

import main.service.IPacoteTurismoService;
import model.PacoteTurismo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PacoteTurismoController {
    @Autowired
    IPacoteTurismoService pacoteTurismoService;

    @GetMapping("/pacotes/{id}")
    public ResponseEntity<PacoteTurismo> getPacote(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(pacoteTurismoService.getByIdPacoteTurismo(id));
    }
    @DeleteMapping("/pacotes/{id}")
    public ResponseEntity<PacoteTurismo> deletePacote(@PathVariable int id){
        return ResponseEntity
                .status(HttpStatusCode.valueOf(204))
                .body(pacoteTurismoService.deleteByIdPacoteTurismo(id));
    }

    @GetMapping("/pacotes")
    public ResponseEntity<List<PacoteTurismo>> getAllPacote(){
        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(pacoteTurismoService.getAllPacote());
    }

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping
    public ResponseEntity<PacoteTurismo> postTurismo(@RequestBody PacoteTurismo pacoteTurismo) {
        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body(pacoteTurismoService.postPacoteTurismo(pacoteTurismo));
    }

}
