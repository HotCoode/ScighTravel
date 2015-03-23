package com.scightravel.model.entities;

import java.io.Serializable;

public class LocationTag implements Serializable {

    private String tagTitle;
    private String tagIconUrl;

    public LocationTag(String tagTitle, String tagIconUrl){

        this.tagTitle = tagTitle;
        this.tagIconUrl = tagIconUrl;
    }

    /**
     * @return The tagTitle
     */
    public String getTagTitle() {
        return tagTitle;
    }

    /**
     * @param tagTitle The tag_title
     */
    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    /**
     * @return The tagIconUrl
     */
    public String getTagIconUrl() {
        return tagIconUrl;
    }

    /**
     * @param tagIconUrl The tag_icon_url
     */
    public void setTagIconUrl(String tagIconUrl) {
        this.tagIconUrl = tagIconUrl;
    }


}