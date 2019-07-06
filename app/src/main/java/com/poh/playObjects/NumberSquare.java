package com.poh.playObjects;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NumberSquare extends Square {
    public static final int MIN_VAL = Integer.MIN_VALUE;
    public static final int MAX_VAL = Integer.MAX_VALUE;
    private Object color;
    private final int value;
}
