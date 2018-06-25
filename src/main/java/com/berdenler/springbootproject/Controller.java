package com.berdenler.springbootproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.ClientHttpResponseStatusCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sun.plugin2.message.Message;

import java.util.List;

@RestController
@RequestMapping("numbers")
public class Controller {
    @Autowired
    private NumbersRepository numbersRepository;

    public Controller(NumbersRepository numbersRepository) {
        this.numbersRepository = numbersRepository;
    }
    @GetMapping("/all")
    public List<NumberEntity> getAll(){
        List<NumberEntity> numberEntities = this.numbersRepository.findAll();
        return numberEntities;
    }
    @PostMapping("/insertNumber")
    public void insert(@RequestBody NumberEntity num){

        this.numbersRepository.insert(num);

    }
    @GetMapping("/maximumNumber")
    public NumberEntity getMaxNum(){
        return this.numbersRepository.findTopByOrderByNumDesc();
    }
    @GetMapping("/minimumNumber")
    public NumberEntity getMin(){
        return this.numbersRepository.findTopByOrderByNumAsc();
    }

    @DeleteMapping("/{number}")
        public void delNum(@PathVariable("number") Integer num){
        if(num != null)
        {this.numbersRepository.deleteByNum(num);}
        else
        {this.numbersRepository.findAll();}

    }
}
