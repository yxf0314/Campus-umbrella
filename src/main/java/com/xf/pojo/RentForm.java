package com.xf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentForm {
    int id;
    int umb_id;
    String username;
    String createtime;
    String returntime;
    String rent_loc;
    String return_loc;
}
