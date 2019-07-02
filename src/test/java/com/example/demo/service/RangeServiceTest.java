package com.example.demo.service;

import com.example.demo.model.RangeThingy;
import com.example.demo.repository.RangeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableCaching
class RangeServiceTest {

    @Mock
    RangeRepo repo;
    @InjectMocks
    RangeService service;

    @BeforeEach
    void setMockOutput() {
        when(repo.findRange(anyLong())).thenReturn(new RangeThingy(1L, 2L, "Yep", 1234L));
    }

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(repo).isNotNull();
        assertThat(service).isNotNull();
    }
    @RepeatedTest(3)
    void testCacheWorks() {
        service.findRangeByIp(1L);
    }

}