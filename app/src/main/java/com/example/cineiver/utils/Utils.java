package com.example.cineiver.utils;

import com.example.cineiver.model.PosterSize;

import static com.example.cineiver.model.PosterSize.LARGE;
import static com.example.cineiver.model.PosterSize.NORMAL;
import static com.example.cineiver.model.PosterSize.SMALL;

public class Utils {
    public static String reduceString(String str){
        return str.length()>Constants.NUMBER_WORDS? str.substring(0,str.length()/(Constants.NUMBER_WORDS/4)).concat("...") : str;
    }
    public static String getPosterPath(PosterSize size,String mPosterPath){
        String path=null;
        switch (size){
            case SMALL:
                path= new StringBuilder().append(Constants.MOVIEAPI_URL_IMG_SMALL).append(mPosterPath).toString();
                break;
            case NORMAL:
                path= new StringBuilder().append(Constants.MOVIEAPI_URL_IMG).append(mPosterPath).toString();
                break;
            case LARGE:
                //  path=new StringBuilder().append(Constants.MOVIEAPI_URL_IMG_SMALL).append(mPosterPath).toString();
                break;
            default:
                break;
        }
        return path;
    }
    public static String getFullVideo_URL(String website,String key){
        String url=null;
        switch (website.toUpperCase()){
            case "YOUTUBE":
                url=Constants.YOUTUBE_URL.concat(key);
                break;
            default:
                break;
        }
        return url;
    }

}
