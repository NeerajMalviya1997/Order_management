package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{

}
