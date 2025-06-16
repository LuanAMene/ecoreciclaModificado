package com.tcc.ecoplus.ecorecicla.controller;

import com.tcc.ecoplus.ecorecicla.exceptions.BadRequest;
import com.tcc.ecoplus.ecorecicla.model.entity.Destinadora;
import com.tcc.ecoplus.ecorecicla.model.entity.Geradora;
import com.tcc.ecoplus.ecorecicla.model.entity.RepresentanteColetora;
import com.tcc.ecoplus.ecorecicla.model.entity.Usuario;
import com.tcc.ecoplus.ecorecicla.model.services.DestinadoraService;
import com.tcc.ecoplus.ecorecicla.model.services.GeradoraService;
import com.tcc.ecoplus.ecorecicla.model.services.RepresentanteColetoraService;
import com.tcc.ecoplus.ecorecicla.model.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class  UsuarioController {

    private final GeradoraService geradoraService;

    private final DestinadoraService destinadoraService;
    private final UsuarioService usuarioService;
    private final RepresentanteColetoraService representanteColetoraService;

    public UsuarioController(GeradoraService geradoraService, DestinadoraService destinadoraService, UsuarioService usuarioService, RepresentanteColetoraService representanteColetoraService) {
        this.geradoraService = geradoraService;
        this.destinadoraService = destinadoraService;
        this.usuarioService = usuarioService;
        this.representanteColetoraService = representanteColetoraService;
    }

    @PostMapping("/geradora")
    public ResponseEntity<Geradora> saveGeradora(@RequestBody Geradora geradora) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/usuario").toUriString());
        return ResponseEntity.created(uri).body(geradoraService.save(geradora));
    }

    @GetMapping("/geradora")
    public ResponseEntity<List<Geradora>>  findAllGeradora() {
        return ResponseEntity.ok().body(geradoraService.findAll());
    }

    @PutMapping("/geradora/{id}")
    public ResponseEntity<Geradora> updateGeradora(@RequestBody Geradora geradora,  @PathVariable(value = "id") String id) {

        try{
            return ResponseEntity.ok().body(geradoraService.update(Long.parseLong(id), geradora));
        }catch (NumberFormatException ex){
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 42.");
        }
    }


    @GetMapping("/geradora/{id}")
    public ResponseEntity<Geradora> findGeradoraById(@PathVariable(value = "id") String id) {
        try{
            Long idLong = Long.parseLong(id);
            return ResponseEntity.ok().body(geradoraService.findById(idLong));
        } catch (NumberFormatException e) {
            throw new BadRequest("'"+id+"' não é um número inteiro válido. Por favor, forneça um valor inteiro.");
        }
    }

    @GetMapping("/geradora/buscar-cnpj")
    public ResponseEntity<List<Geradora>> findByCnpj(@RequestParam String cnpj) {

        return ResponseEntity.ok().body(geradoraService.findByCnpj(cnpj));

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

    @GetMapping()
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {

        return ResponseEntity.ok().body(usuarioService.findByEmail(email));

    }


    @PutMapping("/representante-coletora/{id}")
    public ResponseEntity<RepresentanteColetora> updateRepresentanteColetora(@RequestBody RepresentanteColetora representanteColetora, @PathVariable(value = "id") String id){
        try{
            return ResponseEntity.ok().body(representanteColetoraService.updateGeradora(Long.parseLong(id), representanteColetora));
        }catch (NumberFormatException ex){
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 42.");
        }
    }

}
