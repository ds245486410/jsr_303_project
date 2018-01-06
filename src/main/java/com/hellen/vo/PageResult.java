package com.hellen.vo;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DS on 2018/1/6.
 */
@Getter
public class PageResult<T> implements Serializable {
    private Integer totalPage;
    private Integer totalCount;
    private Integer currentPage = 1;
    private Integer pageSize = 10;
    private Integer nextPage;
    private Integer prevPage;
    private List<T> records;

    public PageResult(Integer totalCount, Integer currentPage, Integer pageSize, List<T> records) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.records = records;
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize +1;
        this.nextPage = currentPage + 1 >= totalPage ? totalPage : currentPage + 1;
        this.prevPage = currentPage - 1 <= 1 ? 1 : currentPage - 1;
    }
}
