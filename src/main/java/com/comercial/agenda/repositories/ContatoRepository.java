package com.comercial.agenda.repositories;

import com.comercial.agenda.modelos.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {

}
