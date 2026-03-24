package com.example.demo.controller;


import com.example.demo.models.PedidoModel;
import com.example.demo.repositories.PedidoRepositories;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedido")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoModel> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        pedidoService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<PedidoModel>criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel requeste = pedidoService.criarPedido(pedidoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pedidoModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

}
