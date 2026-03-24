package com.example.demo.service;


import com.example.demo.models.PedidoModel;
import com.example.demo.repositories.PedidoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepositories pedidoRepositorio;

    public Optional<PedidoModel> findById(Long id) {
        return pedidoRepositorio.findById(id);
    }

    public List<PedidoModel> findAll() {
        return pedidoRepositorio.findAll();
    }

    public void deleteById(Long id) {
        pedidoRepositorio.deleteById(id);
    }

    public PedidoModel criarPedido(PedidoModel livroModel) {
        return pedidoRepositorio.save(livroModel);
    }
}
