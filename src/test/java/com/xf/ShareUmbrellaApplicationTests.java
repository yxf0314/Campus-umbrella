package com.xf;

import com.xf.mapper.ShareMapper;
import com.xf.pojo.Form;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShareUmbrellaApplicationTests {

    @Autowired
    ShareMapper shareMapper;

        @Test
        public void test1(){
            List<Form> findall = shareMapper.Findall();
            for (Form form:findall)
            {
                System.out.println(form);
            }

        }



}
