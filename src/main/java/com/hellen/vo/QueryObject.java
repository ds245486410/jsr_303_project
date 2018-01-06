package com.hellen.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by DS on 2018/1/6.
 */
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class QueryObject implements Serializable{
    private Integer currentPage = 1;
    private Integer pageSize = 10 ;
    public Integer getStart(){
        return (currentPage - 1) * pageSize;
    }
}
