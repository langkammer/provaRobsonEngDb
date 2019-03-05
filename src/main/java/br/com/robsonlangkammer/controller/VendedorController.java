package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.model.Vendedor;
import br.com.robsonlangkammer.repository.VendedorRepository;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class VendedorController extends ResponseFactory {

    private final VendedorRepository vendedorRepository;



    VendedorController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;

    }


    @GetMapping(path = "/vendedor/listar")
    public EvenlopResponse list(){
        try{
            return returnEnvelopSucesso(vendedorRepository.findAll(),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/vendedor/create")
    public EvenlopResponse create(@RequestBody Vendedor vendedor){
        try{
            return returnEnvelopSucesso(vendedorRepository.save(vendedor),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }


    @GetMapping(path = "/vendedor/get/{id}")
    public EvenlopResponse get(@PathVariable Long id){
        try{
            return returnEnvelopSucesso(vendedorRepository.findById(id).get(),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }


    @GetMapping(path = "/vendedor/delete/{id}")
    public EvenlopResponse delete(@PathVariable Long id){

        try{
            vendedorRepository.deleteById(id);
            return returnEnvelopSucesso(null,"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }
    }
}
