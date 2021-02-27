package com.xf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Umbrella {
    int id;
    String state;
    int type;
    String location;
}
