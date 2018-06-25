package com.berdenler.springbootproject;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface NumbersRepository extends MongoRepository<NumberEntity,String> {
    NumberEntity findTopByOrderByNumDesc();
    NumberEntity findTopByOrderByNumAsc();
    void deleteByNum(Integer num);
}
