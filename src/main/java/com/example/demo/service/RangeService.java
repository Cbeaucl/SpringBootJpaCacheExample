package com.example.demo.service;

import com.example.demo.model.RangeThingy;
import com.example.demo.repository.RangeRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RangeService {
    private final RangeRepo repo;

    public RangeService(RangeRepo repo){
        this.repo = repo;
    }
    @Cacheable(cacheNames = "rangeCache")
    public RangeThingy findRangeByIp(Long ip){
        return this.repo.findRange(ip);
    }
}
