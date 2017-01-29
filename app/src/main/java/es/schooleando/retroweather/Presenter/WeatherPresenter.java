package es.schooleando.retroweather.Presenter;

import android.content.Context;

import java.util.List;

import es.schooleando.retroweather.Service.WeatherService;
import es.schooleando.retroweather.model.WeatherModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by ruben on 23/01/17.
 */

public class WeatherPresenter{
    private final Context context;
    private final WeatherPresenterListener mListener;
    private final WeatherService countryService;

    private final String apikey = "3bd52ce2bf3f673cdb99feae185b3c77";

    public interface WeatherPresenterListener{
        void weatherReady(WeatherModel weather);
    }

    public WeatherPresenter(WeatherPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.countryService = new WeatherService();
    }

    public void getWeather(String ciudad) {
        // Aquí llamamos al método de countryService, encolamos y implementamos el callback
        // También deberemos llamar a la Activity a traves del listener (WeatherPresenterListerer)

        countryService
                .getAPI()
                .loadWeather(ciudad,apikey)
                .enqueue(new Callback<WeatherModel>() {
                    @Override
                    public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                        WeatherModel result = response.body();
                        if(result != null) mListener.weatherReady(result);
                    }

                    @Override
                    public void onFailure(Call<WeatherModel> call, Throwable t) {
                        try {
                            throw  new InterruptedException("Error de comunicación con el servidor");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
