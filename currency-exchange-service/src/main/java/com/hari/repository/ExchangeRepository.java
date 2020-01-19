package com.hari.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hari.bean.ExchangeBean;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeBean, Integer> {

	Optional<ExchangeBean> findByFromIgnoreCaseAndToIgnoreCase(String from, String to);

}
