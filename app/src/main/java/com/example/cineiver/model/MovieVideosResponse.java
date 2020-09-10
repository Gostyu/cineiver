
package com.example.cineiver.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class MovieVideosResponse {

    @SerializedName("id")
    private Long mId;
    @SerializedName("results")
    private List<VideoData> mResults;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<VideoData> getResults() {
        return mResults;
    }

    public void setResults(List<VideoData> results) {
        mResults = results;
    }

    @Override
    public String toString() {
        return "MovieVideosResponse{" +
                "mId=" + mId +
                ", mResults=" + mResults +
                '}';
    }
}
