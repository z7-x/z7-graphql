package com.thuni.his.demo.bean.correlationmapping;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("3")
public class Cloth  extends Product{
    private String color;
}
