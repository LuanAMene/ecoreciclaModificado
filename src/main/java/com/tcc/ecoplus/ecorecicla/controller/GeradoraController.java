package com.tcc.ecoplus.ecorecicla.controller;


import com.itb.mif3an.pizzariabomgosto.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Coleta;
import com.tcc.ecoplus.ecorecicla.model.services.ColetaService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/geradora")
public class GeradoraController {

    private final ColetaService coletaService;

    public GeradoraController(ColetaService coletaService) {
        this.coletaService = coletaService;
    }

    @PostMapping("/coleta")
    public ResponseEntity<Coleta> saveColeta(Coleta coleta) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/geradora").toUriString());
        return ResponseEntity.created(uri).body(coletaService.save(coleta));
    }

    @GetMapping("/coleta")
    public ResponseEntity<List<Coleta>> findAllColeta() {
        return ResponseEntity.ok().body(coletaService.findAll());
    }

    @GetMapping("/coleta/{id}")
    public ResponseEntity<Coleta> findAllById(@PathVariable(value = "id") String id) {
        try{
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(coletaService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

}
