package com.wordprocessor.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class Entry {

    private UUID id;
    private Object count;


}