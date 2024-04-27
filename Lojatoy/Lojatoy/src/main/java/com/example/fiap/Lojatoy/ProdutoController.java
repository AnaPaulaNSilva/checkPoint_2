package com.example.fiap.Lojatoy;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Brinquedos")
public class ProdutoController {

	private List<Brinquedo> brinquedos = new ArrayList<>();
	
    @PostMapping
    public Brinquedo criarBrinquedo(@RequestBody Brinquedo brinquedo) {
    	brinquedo.setId(generateNextId());
        brinquedo.add(brinquedo);
        return brinquedo;
    }
    
    @GetMapping
    public List<Brinquedo> listarBrinquedo() {
        return listarBrinquedo();
    }
 
    @PutMapping("/{id}")
    public Brinquedo atualizarBrinquedo(@PathVariable Long id, @RequestBody Brinquedo brinquedo) {
        Brinquedo brinquedoExistente = ((Stream<Brinquedo>) brinquedo.stream())
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("brinquedo não encontrado"));
        
        brinquedoExistente.setNome(brinquedo.getNome());
 
        return brinquedoExistente;
    }
 
    @DeleteMapping("/{id}")
    public void excluirBrinquedo(@PathVariable Long id) {
    	brinquedos.removeIf(u -> u.getId().equals(id));
    }
 
    @GetMapping("/{id}")
    public Brinquedo consultarUsuarioPorId(@PathVariable Long id) {
        return brinquedos.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Brinquedo não encontrado"));
    }
 
    private Long generateNextId() {
        Long maxId = brinquedos.stream()
                .mapToLong(Brinquedo::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}
 

