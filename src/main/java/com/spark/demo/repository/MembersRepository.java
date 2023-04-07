package com.spark.demo.repository;

import com.spark.demo.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {
}
