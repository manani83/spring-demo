package com.pulmuone.webservice.domain.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface ItemsRepository extends JpaRepository<Items, Long> {
    @Query("SELECT i " +
            "FROM Items i " +
            "ORDER BY i.goodsno DESC")
    Stream<Items> findAllDesc();


}
