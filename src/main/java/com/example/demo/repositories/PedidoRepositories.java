package com.example.demo.repositories;

import com.example.demo.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositories extends JpaRepository<PedidoModel,Long> {
}
