package com.xf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    String username;
    String password;
    String name;
    String gender;
    String phone;
    int level;
}
