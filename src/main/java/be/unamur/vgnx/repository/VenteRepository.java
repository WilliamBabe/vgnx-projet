package be.unamur.vgnx.repository;

import be.unamur.vgnx.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Integer> {
}
