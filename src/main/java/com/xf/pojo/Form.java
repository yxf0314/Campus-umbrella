package com.xf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    String destin;
    String origin;
    String time;
    Account authorid;
    Account accepterid;
    String createtime;
    int fid;
}
