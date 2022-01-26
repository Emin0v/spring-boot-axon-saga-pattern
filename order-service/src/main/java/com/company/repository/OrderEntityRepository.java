package com.company.repository;

import com.company.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, String> {
}