package com.example.demo.repository;

import com.example.demo.model.RangeThingy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RangeRepoTest {
    @Autowired
    private RangeRepo repo;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(repo).isNotNull();
    }

    @Test
    void findRangeValueUsingMin(){
        RangeThingy expected = new RangeThingy(1L, 10L, "WOO!", 1234L);
        repo.save(new RangeThingy(1L, 10L, "WOO!", 1234L));
        repo.save(new RangeThingy(11L, 15L, "OHNO", 171717L));
        repo.flush();
        RangeThingy actual = repo.findRange(4L);
        assertThat(actual).isEqualTo(expected);
    }
}