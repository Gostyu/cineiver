
package com.example.cineiver.model;

import com.example.cineiver.utils.Constants;
import com.example.cineiver.utils.Utils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class VideoData {

    @Expose
    private String id;
    @SerializedName("iso_3166_1")
    private String iso31661;
    @SerializedName("iso_639_1")
    private String iso6391;
    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private String site;
    @Expose
    private Long size;
    @Expose
    private String type;

    private String videoLink;

    public String getVideoLink() {
        return Utils.getFullVideo_URL(site,key);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso31661() {
        return iso31661;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VideoData{" +
                "id='" + id + '\'' +
                ", iso31661='" + iso31661 + '\'' +
                ", iso6391='" + iso6391 + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", videoLink='" + getVideoLink() + '\'' +
                '}';
    }
}
