package br.com.bluesoft.alugar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluesoft.alugar.modelo.Carro;

public interface CarroRepository extends JpaRepository<Carro, String>{

	Optional<Carro> findByPlaca(String placa);

}
