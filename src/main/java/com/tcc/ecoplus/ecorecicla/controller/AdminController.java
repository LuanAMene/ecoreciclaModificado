package com.tcc.ecoplus.ecorecicla.controller;


import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Residuo;
import com.tcc.ecoplus.ecorecicla.model.services.ResiduoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

private final ResiduoService residuoService;

    public AdminController(ResiduoService residuoService) {
        this.residuoService = residuoService;
    }

    @PostMapping("/residuo")
    public ResponseEntity<Residuo> saveResiduo(@RequestBody Residuo residuo) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/geradora").toUriString());
        return ResponseEntity.created(uri).body(residuoService.save(residuo));
    }

    @GetMapping("/residuo")
    public ResponseEntity<List<Residuo>> findAll() {
        return ResponseEntity.ok(residuoService.findAll());
    }

    @GetMapping("/residuo")
    public ResponseEntity<Residuo> findById(@PathVariable(value = "id") String id) {
        try{
            Long IdLongLong = Long.parseLong(id);
            return ResponseEntity.ok().body(residuoService.findById(IdLongLong));
        }catch (NumberFormatException e){
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }
}
