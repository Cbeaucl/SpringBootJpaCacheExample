package com.example.demo.repository;

import com.example.demo.model.RangeThingy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeRepo extends JpaRepository<RangeThingy, Long> {

    @Query(value = "select thing from RangeThingy thing where thing.first = (select min(b.first) from RangeThingy b where b.first <= :longValue)")
    RangeThingy findRange(long longValue);
}
