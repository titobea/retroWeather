package es.schooleando.retroweather.Presenter;

import android.content.Context;

import es.schooleando.retroweather.Service.WeatherService;
import es.schooleando.retroweather.model.WeatherModel;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherPresenter {
    private final Context context;
    private final WeatherPresenterListener mListener;
    private final WeatherService countryService;

    public interface WeatherPresenterListener{
        void weatherReady(WeatherModel weather);
    }

    public WeatherPresenter(WeatherPresenterListener listener, Context context){
        this.mListener = listener;
        this.context = context;
        this.countryService = new WeatherService();
    }

    public void getWeather() {
        // Aquí llamamos al método de countryService, encolamos y implementamos el callback
        // También deberemos llamar a la Activity a traves del listener (WeatherPresenterListerer)
    }
}
