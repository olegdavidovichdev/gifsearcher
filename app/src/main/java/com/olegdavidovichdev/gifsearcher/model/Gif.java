package com.olegdavidovichdev.gifsearcher.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Gif {



    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("bitly_gif_url")
    @Expose
    private String bitlyGifUrl;
    @SerializedName("bitly_url")
    @Expose
    private String bitlyUrl;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("content_url")
    @Expose
    private String contentUrl;
    @SerializedName("source_tld")
    @Expose
    private String sourceTld;
    @SerializedName("source_post_url")
    @Expose
    private String sourcePostUrl;
    @SerializedName("import_datetime")
    @Expose
    private String importDatetime;
    @SerializedName("trending_datetime")
    @Expose
    private String trendingDatetime;
    @SerializedName("images")
    @Expose
    private Images images;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Gif() {
    }

    /**
     * 
     * @param importDatetime
     * @param bitlyGifUrl
     * @param contentUrl
     * @param embedUrl
     * @param sourceTld
     * @param caption
     * @param type
     * @param trendingDatetime
     * @param url
     * @param bitlyUrl
     * @param id
     * @param username
     * @param source
     * @param sourcePostUrl
     * @param images
     * @param slug
     * @param rating
     */
    public Gif(String type, String id, String slug, String url, String bitlyGifUrl, String bitlyUrl, String embedUrl, String username, String source, String rating, String caption, String contentUrl, String sourceTld, String sourcePostUrl, String importDatetime, String trendingDatetime, Images images) {
        this.type = type;
        this.id = id;
        this.slug = slug;
        this.url = url;
        this.bitlyGifUrl = bitlyGifUrl;
        this.bitlyUrl = bitlyUrl;
        this.embedUrl = embedUrl;
        this.username = username;
        this.source = source;
        this.rating = rating;
        this.caption = caption;
        this.contentUrl = contentUrl;
        this.sourceTld = sourceTld;
        this.sourcePostUrl = sourcePostUrl;
        this.importDatetime = importDatetime;
        this.trendingDatetime = trendingDatetime;
        this.images = images;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * 
     * @param slug
     *     The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The bitlyGifUrl
     */
    public String getBitlyGifUrl() {
        return bitlyGifUrl;
    }

    /**
     * 
     * @param bitlyGifUrl
     *     The bitly_gif_url
     */
    public void setBitlyGifUrl(String bitlyGifUrl) {
        this.bitlyGifUrl = bitlyGifUrl;
    }

    /**
     * 
     * @return
     *     The bitlyUrl
     */
    public String getBitlyUrl() {
        return bitlyUrl;
    }

    /**
     * 
     * @param bitlyUrl
     *     The bitly_url
     */
    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    /**
     * 
     * @return
     *     The embedUrl
     */
    public String getEmbedUrl() {
        return embedUrl;
    }

    /**
     * 
     * @param embedUrl
     *     The embed_url
     */
    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 
     * @param caption
     *     The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 
     * @return
     *     The contentUrl
     */
    public String getContentUrl() {
        return contentUrl;
    }

    /**
     * 
     * @param contentUrl
     *     The content_url
     */
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    /**
     * 
     * @return
     *     The sourceTld
     */
    public String getSourceTld() {
        return sourceTld;
    }

    /**
     * 
     * @param sourceTld
     *     The source_tld
     */
    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    /**
     * 
     * @return
     *     The sourcePostUrl
     */
    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    /**
     * 
     * @param sourcePostUrl
     *     The source_post_url
     */
    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    /**
     * 
     * @return
     *     The importDatetime
     */
    public String getImportDatetime() {
        return importDatetime;
    }

    /**
     * 
     * @param importDatetime
     *     The import_datetime
     */
    public void setImportDatetime(String importDatetime) {
        this.importDatetime = importDatetime;
    }

    /**
     * 
     * @return
     *     The trendingDatetime
     */
    public String getTrendingDatetime() {
        return trendingDatetime;
    }

    /**
     * 
     * @param trendingDatetime
     *     The trending_datetime
     */
    public void setTrendingDatetime(String trendingDatetime) {
        this.trendingDatetime = trendingDatetime;
    }

    /**
     * 
     * @return
     *     The images
     */
    public Images getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(Images images) {
        this.images = images;
    }


    public class Images {


        @SerializedName("original_still")
        @Expose
        private OriginalStill originalStill;


        @SerializedName("original")
        @Expose
        private Original original;

        /**
         * No args constructor for use in serialization
         *
         */
        public Images() {
        }

        /**
         *
         * @param originalStill
         */
        public Images(OriginalStill originalStill) {
            this.originalStill = originalStill;

        }

        /**
         *
         * @return
         *     The originalStill
         */
        public OriginalStill getOriginalStill() {
            return originalStill;
        }

        /**
         *
         * @param originalStill
         *     The originalStill
         */
        public void setOriginalStill(OriginalStill originalStill) {
            this.originalStill = originalStill;


        }

        public Original getOriginal() {
            return original;
        }

        public void setOriginal(Original original) {
            this.original = original;
        }


        public class OriginalStill {

            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("width")
            @Expose
            private String width;
            @SerializedName("height")
            @Expose
            private String height;

            /**
             * No args constructor for use in serialization
             *
             */
            public OriginalStill() {
            }

            /**
             *
             * @param height
             * @param width
             * @param url
             */
            public OriginalStill(String url, String width, String height) {
                this.url = url;
                this.width = width;
                this.height = height;
            }

            /**
             *
             * @return
             *     The url
             */
            public String getUrl() {
                return url;
            }

            /**
             *
             * @param url
             *     The url
             */
            public void setUrl(String url) {
                this.url = url;
            }

            /**
             *
             * @return
             *     The width
             */
            public String getWidth() {
                return width;
            }

            /**
             *
             * @param width
             *     The width
             */
            public void setWidth(String width) {
                this.width = width;
            }

            /**
             *
             * @return
             *     The height
             */
            public String getHeight() {
                return height;
            }

            /**
             *
             * @param height
             *     The height
             */
            public void setHeight(String height) {
                this.height = height;
            }

        }

        public class Original {

            @SerializedName("url")
            @Expose
            private String url;


            /**
             * No args constructor for use in serialization
             *
             */
            public Original() {
            }

            /**
             *
             * @param url
             */
            public Original(String url) {
                this.url = url;
            }

            /**
             *
             * @return
             *     The url
             */
            public String getUrl() {
                return url;
            }

            /**
             *
             * @param url
             *     The url
             */
            public void setUrl(String url) {
                this.url = url;
            }


        }

    }



}
