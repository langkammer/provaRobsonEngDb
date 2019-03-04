package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.model.Vendedor;
import br.com.robsonlangkammer.repository.VendedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendedorController {

    private final VendedorRepository vendedorRepository;



    VendedorController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;

    }


    @GetMapping(path = "/vendedor/listar")
    public List<Vendedor> list(){
        return vendedorRepository.findAll();
    }

    @PostMapping(path = "/vendedor/create")
    public Vendedor create(@RequestBody Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }


    @GetMapping(path = "/vendedor/get/{id}")
    public Vendedor get(@PathVariable Long id){
        Vendedor vendedor = vendedorRepository.findById(id).get();
        return vendedor;
    }
}
