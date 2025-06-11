package com.tcc.ecoplus.ecorecicla.controller;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;
import com.tcc.ecoplus.ecorecicla.model.entity.Geradora;
import com.tcc.ecoplus.ecorecicla.model.services.DestinadoraService;
import com.tcc.ecoplus.ecorecicla.model.services.GeradoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final GeradoraService geradoraService;

    private final DestinadoraService destinadoraService;

    public UsuarioController(GeradoraService geradoraService, DestinadoraService destinadoraService) {
        this.geradoraService = geradoraService;
        this.destinadoraService = destinadoraService;
    }

    @PostMapping("/geradora")
    public ResponseEntity<Geradora> saveGeradora(@RequestBody Geradora geradora) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/usuario").toUriString());
        return ResponseEntity.created(uri).body(geradoraService.save(geradora));
    }

    @GetMapping("/geradora")
    public ResponseEntity<List<Geradora>>  findAllGeradora() {
        return ResponseEntity.ok().body(geradoraService.findAll());
    }    @GetMapping("/geradora/{id}")

    public ResponseEntity<Geradora> findGeradoraById(@PathVariable(value = "id") String id) {
        try{
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(geradoraService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    @PostMapping("/destinadora")
    public ResponseEntity<Destinadora> saveDestinadora(@RequestBody Destinadora destinadora) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/usuario").toUriString());
        return ResponseEntity.created(uri).body(destinadoraService.save(destinadora));
    }

    @GetMapping("/destinadora")
    public ResponseEntity<List<Destinadora>>  findAllDestinadora() {
        return ResponseEntity.ok().body(destinadoraService.findAll());
    }    @GetMapping("/destinadora/{id}")

    public ResponseEntity<Destinadora> findDestinadoraById(@PathVariable(value = "id") String id) {
        try{
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(destinadoraService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }


}
