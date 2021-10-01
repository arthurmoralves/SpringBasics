package br.com.estudo.api.cinema.estudo.controller;

import br.com.estudo.api.cinema.estudo.entity.ClienteEntity;
import br.com.estudo.api.cinema.estudo.entity.SessaoEntity;
import br.com.estudo.api.cinema.estudo.model.Cliente;
import br.com.estudo.api.cinema.estudo.model.Sala;
import br.com.estudo.api.cinema.estudo.model.Sessao;
import br.com.estudo.api.cinema.estudo.model.Venda;
import br.com.estudo.api.cinema.estudo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    SessaoService sessaoService;

    @Autowired
    VendaService vendaService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> cadastrarUsuario(@RequestBody Cliente cliente){
       return ResponseEntity.ok(clienteService.cadastrar(cliente));
    }

    @PostMapping("/sessao")
    public ResponseEntity<Sessao> cadastrarSessao(@RequestBody Sessao sessao){
        return ResponseEntity.ok(sessaoService.cadastrar(sessao));
    }

    @GetMapping("/sessao")
    public List<Sessao> consultarSessao(){
        var sessao = sessaoService.consultar();
        return sessao;
    }

    @GetMapping("/sessao/{titulo}")
    public ResponseEntity<Sessao> consultarSessaoPorTitulo(@PathVariable String titulo){
        var sessao = sessaoService.consultarPorTitulo(titulo);
        if(sessao == null){
           return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(sessao);
        }
    }

    @GetMapping("/vendas")
    public List<Venda> consultarVendas(){
        return vendaService.consultarVendas();
    }


    @GetMapping("/salas")
    public List<Sala> consultarsalas(){
        return salaService.consultarSalas();
    }

    @PostMapping
    public ResponseEntity<Venda> cadastrarVenda(@RequestBody Venda venda){
        return ResponseEntity.ok(vendaService.cadastrarVenda(venda));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody String username, String password){
        var login = loginService.validaLogin(username, password);
        if(login){
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }
}