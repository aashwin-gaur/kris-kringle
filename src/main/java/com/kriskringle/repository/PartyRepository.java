package com.kriskringle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kriskringle.domain.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, String> {

}
