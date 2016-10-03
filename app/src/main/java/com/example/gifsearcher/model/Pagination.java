package com.example.gifsearcher.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Pagination {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param count
     * @param offset
     */
    public Pagination(Integer count, Integer offset) {
        this.count = count;
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
