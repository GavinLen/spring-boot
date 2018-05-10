package xyz.ieden.dm.entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author ThinkPad
 * @date Created by 2018/5/10 14:36
 */
public class SimplePageable implements Serializable, Pageable {


    private static final long serialVersionUID = -1L;

    /**
     * 当前页数
     */
    private Integer pageNumber = 1;
    /**
     * 页面数量
     */
    private Integer pageSize = 10;
    /**
     * 排序条件
     */
    private Sort sort;

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber - 1;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public long getOffset() {
        return (this.getPageNumber()) * this.pageSize;
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
