package br.com.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exemplo.model.Convidado;

public interface IConvidados extends JpaRepository<Convidado, Long>{

}
