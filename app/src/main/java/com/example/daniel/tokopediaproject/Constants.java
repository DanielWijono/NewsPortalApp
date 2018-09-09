package com.example.daniel.tokopediaproject;

public class Constants {

    public static final long TIMEOUT_CONNECTION = 15;


    public interface URL_API {
        String BASE_URL = "https://newsapi.org/v2/";
        String BUSINESS = "top-headlines?country=us&category=business&apiKey=12211a3b99b840178caf52ea420be870";
        String BITCOIN = "everything?q=bitcoin&sortBy=publishedAt&apiKey=12211a3b99b840178caf52ea420be870";
        String TECHCRUNCH = "top-headlines?sources=techcrunch&apiKey=12211a3b99b840178caf52ea420be870";
        String APPLE = "everything?q=apple&from=2018-09-08&to=2018-09-08&sortBy=popularity&apiKey=12211a3b99b840178caf52ea420be870";
        String WALLSTREET = "everything?domains=wsj.com&apiKey=12211a3b99b840178caf52ea420be870";
    }
}
