package com.berdenler.springbootproject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Document (collection = "NumberEntity")
public class NumberEntity {


    @Id
    private String id;

    @Indexed(unique = true, direction =IndexDirection.ASCENDING)
    private int num;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String insert_date= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss"));
    public NumberEntity(){}
    public NumberEntity(int num){
        this.num = num;
    }

    public String getId(){return id;}
    public  int getNum(){
        return num;
    }
    public void setNum(int num){this.num=num;}
    public String getDate() {
        return insert_date;
    }
}
