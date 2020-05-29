package com.thuni.his.demo.bean.correlationmapping;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("2")
public class Book extends Product{
    private String ISBN;
}
