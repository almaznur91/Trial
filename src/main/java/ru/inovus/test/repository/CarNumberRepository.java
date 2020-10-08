package ru.inovus.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inovus.test.entity.CarNumberEntity;

@Repository
public interface CarNumberRepository extends JpaRepository<CarNumberEntity, Integer> {


}
