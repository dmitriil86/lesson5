package com.example.lesson5.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Data
public class TppRefAccountType {

    @Column(name = "internal_id")
    private Integer internalId;

    @Id
    @Column(length = 100, name = "value", unique = true, nullable = false)
    private String value;

}
