package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.entity.RecentTransaction;
@Repository
public interface RecentTransactionRepository extends JpaRepository<RecentTransaction, Long>{

}
