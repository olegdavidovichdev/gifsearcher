package com.olegdavidovichdev.gifsearcher.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GifResponse {

    @SerializedName("data")
    @Expose
    private List<Gif> data;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GifResponse() {
    }

    /**
     * 
     * @param data
     * @param pagination
     * @param meta
     */
    public GifResponse(List<Gif> data, Pagination pagination, Meta meta) {
        this.data = data;
        this.pagination = pagination;
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The data
     */
    public List<Gif> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Gif> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 
     * @param pagination
     *     The pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
