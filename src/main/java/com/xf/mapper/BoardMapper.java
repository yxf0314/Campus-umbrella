package com.xf.mapper;

import com.xf.pojo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    int AddMsg(String username,String text);
    List<Board> SelectAllMsg();
}
