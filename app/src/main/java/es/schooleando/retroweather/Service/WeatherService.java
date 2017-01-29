package es.schooleando.retroweather.Service;

import java.util.List;

import es.schooleando.retroweather.model.WeatherModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherService {

    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public interface WeatherAPI {
        @GET("weather")
        Call<WeatherModel> loadWeather(@Query("q") String ciudad,@Query("appid") String apikey);
    }

    public WeatherAPI getAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(WeatherAPI.class);
    }
}
