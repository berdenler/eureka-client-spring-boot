package com.berdenler.springbootproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbNumbers implements CommandLineRunner {
    private NumbersRepository numbersRepository;

    public DbNumbers(NumbersRepository numbersRepository){
        this.numbersRepository = numbersRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        NumberEntity one = new NumberEntity(1);
        NumberEntity two = new NumberEntity(2);
        NumberEntity three = new NumberEntity(3);
        NumberEntity four = new NumberEntity(4);
        NumberEntity five = new NumberEntity(5);
        //drop all numbers
        this.numbersRepository.deleteAll();
        //inserting numbers into MongoDb
        List<NumberEntity> records = Arrays.asList(one,two,three,four,five);
        this.numbersRepository.saveAll(records);
    }
}
