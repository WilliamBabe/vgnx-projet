package be.unamur.vgnx.repository;

import be.unamur.vgnx.entity.Echange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchangeRepository extends JpaRepository <Echange, Integer> {
}
