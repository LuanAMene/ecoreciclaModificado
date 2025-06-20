package com.tcc.ecoplus.ecorecicla.controller;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;
import com.tcc.ecoplus.ecorecicla.model.entity.Residuo_Destinadora;
import com.tcc.ecoplus.ecorecicla.model.services.DestinadoraService;
import com.tcc.ecoplus.ecorecicla.model.services.ResiduoDestinadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/destinadora")
public class DestinadoraController {

private final ResiduoDestinadoraService residuoDestinadoraService;

private final DestinadoraService destinadoraService;

    public DestinadoraController(ResiduoDestinadoraService residuoDestinadoraService, DestinadoraService destinadoraService) {
        this.residuoDestinadoraService = residuoDestinadoraService;
        this.destinadoraService = destinadoraService;
    }

    @PostMapping("/residuo_destinadora")
    public ResponseEntity<Residuo_Destinadora> saveResiduoDestinadora(@RequestBody Residuo_Destinadora residuo_destinadora) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/geradora").toUriString());
        return ResponseEntity.created(uri).body(residuoDestinadoraService.save(residuo_destinadora));
    }

    @GetMapping("/residuo_destinadora")
    public ResponseEntity<List<Residuo_Destinadora>> findAll() {
        return ResponseEntity.ok(residuoDestinadoraService.findAll());
    }

    @GetMapping("/residuo_destinadora/{id}")
    public ResponseEntity<Residuo_Destinadora> findById(@PathVariable(value = "id") String id) {
        try {Long idLong = Long.parseLong(id);
        return ResponseEntity.ok(residuoDestinadoraService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    @GetMapping("/residuos")
    public ResponseEntity<List<Destinadora>> getDestinadorasByTipoOuClasse(
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String classe) {

        return ResponseEntity.ok(destinadoraService.findByTipoAndClasse(tipo, classe));
    }
}
