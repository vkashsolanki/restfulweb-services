package com.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.entity.RecentTransaction;

@Repository
public interface RecentTransactionRepository extends JpaRepository<RecentTransaction, Integer>{

}
