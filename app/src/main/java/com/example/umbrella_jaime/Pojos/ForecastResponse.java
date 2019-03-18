package com.example.umbrella_jaime.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ForecastResponse {
    @SerializedName("coord")
    public Coord coord;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("weather")
    public ArrayList<Weather> weather = new ArrayList<Weather>();
    @SerializedName("main")
    public Main main;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("rain")
    public Rain rain;
    @SerializedName("clouds")
    public Clouds clouds;
    @SerializedName("dt")
    public float dt;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("cod")
    public float cod;
    @SerializedName("city")
    public City city;
    @SerializedName("datafetch")
    public Datafetch datafetch;
    @SerializedName("list")
    public List list;
    @SerializedName("temp_kf")
    public Double tempKf;
    @SerializedName("temp_max")
    public Double tempMax;
    @SerializedName("temp")
    public Double temp;


    static class Datafetch {

        @SerializedName("cod")
        @Expose
        public String cod;
        @SerializedName("message")
        @Expose
        public Double message;
        @SerializedName("cnt")
        @Expose
        public Integer cnt;
        @SerializedName("list")
        @Expose
        public java.util.List<ForecastResponse> list = null;
        @SerializedName("city")
        @Expose
        public ForecastResponse city;

    }

    static class Rain {

        @SerializedName("3h")
        @Expose
        public Double _3h;

    }

    static class Weather {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("main")
        @Expose
        public String main;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("icon")
        @Expose
        public String icon;

    }

    static class Snow {

        @SerializedName("3h")
        @Expose
        public Double _3h;

    }

    static class Main {

        @SerializedName("temp")
        @Expose
        public Double temp;
        @SerializedName("temp_min")
        @Expose
        public Double tempMin;
        @SerializedName("temp_max")
        @Expose
        public Double tempMax;
        @SerializedName("pressure")
        @Expose
        public Double pressure;
        @SerializedName("sea_level")
        @Expose
        public Double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        public Double grndLevel;
        @SerializedName("humidity")
        @Expose
        public Integer humidity;
        @SerializedName("temp_kf")
        @Expose
        public Double tempKf;

    }

    static class Sys {

        @SerializedName("pod")
        @Expose
        public String pod;

    }

    static class Wind {

        @SerializedName("speed")
        @Expose
        public Double speed;
        @SerializedName("deg")
        @Expose
        public Double deg;

    }

    static class List {

        @SerializedName("dt")
        @Expose
        public Integer dt;
        @SerializedName("main")
        @Expose
        public Main main;
        @SerializedName("weather")
        @Expose
        public java.util.List<Weather> weather = null;
        @SerializedName("clouds")
        @Expose
        public ForecastResponse clouds;
        @SerializedName("wind")
        @Expose
        public Wind wind;
        @SerializedName("snow")
        @Expose
        public Snow snow;
        @SerializedName("sys")
        @Expose
        public Sys sys;
        @SerializedName("dt_txt")
        @Expose
        public String dtTxt;
        @SerializedName("rain")
        @Expose
        public Rain rain;

    }

    static class Clouds {

        @SerializedName("all")
        @Expose
        public Integer all;

    }

    static class Coord {

        @SerializedName("lat")
        @Expose
        public Double lat;
        @SerializedName("lon")
        @Expose
        public Double lon;

    }

    static class City {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("coord")
        @Expose
        public Coord coord;
        @SerializedName("country")
        @Expose
        public String country;

    }
}









