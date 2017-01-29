package es.schooleando.retroweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import es.schooleando.retroweather.Presenter.WeatherPresenter;
import es.schooleando.retroweather.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherPresenter.WeatherPresenterListener{

    private ListView listaCiudades;
    private TextView situacion;
    private ImageView icono;
    private TextView temperatura;
    private TextView viento;
    private TextView humedad;

    private ArrayList<String> ciudades = new ArrayList<String>(){};

    private String ciudadElegida;

    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCiudades=(ListView)findViewById(R.id.listaCiudades);
        situacion=(TextView)findViewById(R.id.situacion);
        icono=(ImageView)findViewById(R.id.icono);
        temperatura=(TextView)findViewById(R.id.temperatura);
        viento=(TextView)findViewById(R.id.viento);
        humedad=(TextView)findViewById(R.id.humedad);

        llenarCiudades();
        ciudadElegida=ciudades.get(0);
        Collections.sort(ciudades,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, ciudades);

        listaCiudades.setAdapter(arrayAdapter);
        listaCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
                    {
                        ciudadElegida=ciudades.get(position);
                        weatherPresenter.getWeather(ciudadElegida);
                    }
            });
        weatherPresenter = new WeatherPresenter(this, this);
    }

    @Override
    public void weatherReady(WeatherModel weather) {
        // aquí obtenemos las actualizaciones gracias a WeatherPresenter
        situacion.setText(weather.getWeather().get(0).getDescription());
        Picasso.with(this).load("http://openweathermap.org/img/w/"+weather.getWeather().get(0).getIcon()+".png").into(icono);
        temperatura.setText(weather.getMain().getTemp()+" kelvin, "+Math.round((Double.parseDouble(weather.getMain().getTemp())-273.15d)* 100.0) / 100.0+" Celsius");
        viento.setText(weather.getWind().getSpeed()+" m/s, "+Math.round((Double.parseDouble(weather.getWind().getSpeed())*3.6d)* 100.0) / 100.0+" km/h");
        humedad.setText(weather.getMain().getHumidity()+" %");
    }

    public void actualizar(View v){
        weatherPresenter.getWeather(ciudadElegida);
    }

    private void llenarCiudades(){
        ciudades.add("Valencia,es");
        ciudades.add("Nueva York,us");
        ciudades.add("Kabul,af");
        ciudades.add("Tirana,al");
        ciudades.add("Algiers,dz");
        ciudades.add("Pago Pago,as");
        ciudades.add("Andorra,ad");
        ciudades.add("Luanda,ao");
        ciudades.add("The Valley,ai");
        ciudades.add("None,aq");
        ciudades.add("St. Johns,ag");
        ciudades.add("Buenos Aires,ar");
        ciudades.add("Yerevan,am");
        ciudades.add("Oranjestad,aw");
        ciudades.add("Canberra,au");
        ciudades.add("Vienna,at");
        ciudades.add("Baku,az");
        ciudades.add("Nassau,bs");
        ciudades.add("Al-Manamah,bh");
        ciudades.add("Dhaka,bd");
        ciudades.add("Bridgetown,bb");
        ciudades.add("Minsk,by");
        ciudades.add("Brussels,be");
        ciudades.add("Belmopan,bz");
        ciudades.add("Porto-Novo,bj");
        ciudades.add("Hamilton,bm");
        ciudades.add("Thimphu,bt");
        ciudades.add("La Paz,bo");
        ciudades.add("Sarajevo,ba");
        ciudades.add("Gaborone,bw");
        ciudades.add("None,bv");
        ciudades.add("Brasilia,br");
        ciudades.add("None,io");
        ciudades.add("Bandar Seri Begawan,bn");
        ciudades.add("Sofia,bg");
        ciudades.add("Ouagadougou,bf");
        ciudades.add("Bujumbura,bi");
        ciudades.add("Phnom Penh,kh");
        ciudades.add("Yaounde,cm");
        ciudades.add("Ottawa,ca");
        ciudades.add("Praia,cv");
        ciudades.add("Georgetown,ky");
        ciudades.add("Bangui,cf");
        ciudades.add("N'Djamena,td");
        ciudades.add("Santiago,cl");
        ciudades.add("Beijing,cn");
        ciudades.add("The Settlement,cx");
        ciudades.add("West Island,cc");
        ciudades.add("Bogota,co");
        ciudades.add("Moroni,km");
        ciudades.add("Brazzaville,cg");
        ciudades.add("Kinshasa,cd");
        ciudades.add("Avarua,ck");
        ciudades.add("San Jose,cr");
        ciudades.add("Zagreb,hr");
        ciudades.add("Havana,cu");
        ciudades.add("Nicosia,cy");
        ciudades.add("Prague,cz");
        ciudades.add("Copenhagen,dk");
        ciudades.add("Djibouti,dj");
        ciudades.add("Roseau,dm");
        ciudades.add("Santo Domingo,do");
        ciudades.add("Quito,ec");
        ciudades.add("Cairo,eg");
        ciudades.add("San Salvador,sv");
        ciudades.add("Malabo,gq");
        ciudades.add("Asmara,er");
        ciudades.add("Tallinn,ee");
        ciudades.add("Addis Ababa,et");
        ciudades.add("Brussels,eu.int");
        ciudades.add("Stanley,fk");
        ciudades.add("Torshavn,fo");
        ciudades.add("Suva,fj");
        ciudades.add("Helsinki,fi");
        ciudades.add("Paris,fr");
        ciudades.add("Cayenne,gf");
        ciudades.add("None,tf");
        ciudades.add("Libreville,ga");
        ciudades.add("Banjul,gm");
        ciudades.add("Tbilisi,ge");
        ciudades.add("Berlin,de");
        ciudades.add("Accra,gh");
        ciudades.add("Gibraltar,gi");
        ciudades.add("London,gb");
        ciudades.add("Athens,gr");
        ciudades.add("Godthab,gl");
        ciudades.add("St. George's,gd");
        ciudades.add("Basse-Terre,gp");
        ciudades.add("Agana,gu");
        ciudades.add("Guatemala City,gt");
        ciudades.add("St. Peter Port,gg");
        ciudades.add("Conakry,gn");
        ciudades.add("Bissau,gw");
        ciudades.add("Georgetown,gy");
        ciudades.add("Port-au-Prince,ht");
        ciudades.add("None,hm");
        ciudades.add("Tegucigalpa,hn");
        ciudades.add("Victoria,hk");
        ciudades.add("Budapest,hu");
        ciudades.add("Reykjavik,is");
        ciudades.add("New Delhi,in");
        ciudades.add("Jakarta,id");
        ciudades.add("Tehran,ir");
        ciudades.add("Baghdad,iq");
        ciudades.add("Dublin,ie");
        ciudades.add("Douglas,im");
        ciudades.add("Jerusalem,il");
        ciudades.add("Rome,it");
        ciudades.add("Abidjan,ci");
        ciudades.add("Kingston,jm");
        ciudades.add("Tokyo,jp");
        ciudades.add("Saint Helier,je");
        ciudades.add("Amman,jo");
        ciudades.add("Astana,kz");
        ciudades.add("Nairobi,ke");
        ciudades.add("Tarawa,ki");
        ciudades.add("Pyongyang,kp");
        ciudades.add("Seoul,kr");
        ciudades.add("Kuwait City,kw");
        ciudades.add("Bishkek,kg");
        ciudades.add("Vientiane,la");
        ciudades.add("Riga,lv");
        ciudades.add("Beirut,lb");
        ciudades.add("Maseru,ls");
        ciudades.add("Monrovia,lr");
        ciudades.add("Tripoli,ly");
        ciudades.add("Vaduz,li");
        ciudades.add("Vilnius,lt");
        ciudades.add("Luxembourg,lu");
        ciudades.add("Macau,mo");
        ciudades.add("Skopje,mk");
        ciudades.add("Antananarivo,mg");
        ciudades.add("Lilongwe,mw");
        ciudades.add("Kuala Lumpur,my");
        ciudades.add("Male,mv");
        ciudades.add("Bamako,ml");
        ciudades.add("Valletta,mt");
        ciudades.add("Majuro,mh");
        ciudades.add("Fort-de-France,mq");
        ciudades.add("Nouakchott,mr");
        ciudades.add("Port Louis,mu");
        ciudades.add("Dzaoudzi,yt");
        ciudades.add("Mexico City,mx");
        ciudades.add("Palikir,fm");
        ciudades.add("Kishinev,md");
        ciudades.add("Monaco,mc");
        ciudades.add("Ulan Bator,mn");
        ciudades.add("Podgorica,me");
        ciudades.add("Plymouth,ms");
        ciudades.add("Rabat,ma");
        ciudades.add("Maputo,mz");
        ciudades.add("Naypyidaw,mm");
        ciudades.add("Windhoek,na");
        ciudades.add("Yaren,nr");
        ciudades.add("Kathmandu,np");
        ciudades.add("Amsterdam,nl");
        ciudades.add("Willemstad,an");
        ciudades.add("Noumea,nc");
        ciudades.add("Wellington,nz");
        ciudades.add("Managua,ni");
        ciudades.add("Niamey,ne");
        ciudades.add("Lagos,ng");
        ciudades.add("Alofi,nu");
        ciudades.add("Kingston,nf");
        ciudades.add("Saipan,mp");
        ciudades.add("Oslo,no");
        ciudades.add("Muscat,om");
        ciudades.add("Islamabad,pk");
        ciudades.add("Koror,pw");
        ciudades.add("Panama City,pa");
        ciudades.add("Port Moresby,pg");
        ciudades.add("Asuncion,py");
        ciudades.add("Lima,pe");
        ciudades.add("Manila,ph");
        ciudades.add("Adamstown,pn");
        ciudades.add("Warsaw,pl");
        ciudades.add("Papeete,pf");
        ciudades.add("Lisbon,pt");
        ciudades.add("San Juan,pr");
        ciudades.add("Doha,qa");
        ciudades.add("Saint-Denis,re");
        ciudades.add("Bucharest,ro");
        ciudades.add("Moscow,ru");
        ciudades.add("Kigali,rw");
        ciudades.add("Jamestown,sh");
        ciudades.add("Basseterre,kn");
        ciudades.add("Castries,lc");
        ciudades.add("St. Pierre,pm");
        ciudades.add("Kingstown,vc");
        ciudades.add("Apia,ws");
        ciudades.add("San Marino,sm");
        ciudades.add("Sao Tome,st");
        ciudades.add("Riyadh,sa");
        ciudades.add("Dakar,sn");
        ciudades.add("Belgrade,rs");
        ciudades.add("Victoria,sc");
        ciudades.add("Freetown,sl");
        ciudades.add("Singapore,sg");
        ciudades.add("Bratislava,sk");
        ciudades.add("Ljubljana,si");
        ciudades.add("Honiara,sb");
        ciudades.add("Mogadishu,so");
        ciudades.add("Pretoria,za");
        ciudades.add("None,gs");
        ciudades.add("Ramciel,ss");
        ciudades.add("Madrid,es");
        ciudades.add("Colombo,lk");
        ciudades.add("Khartoum,sd");
        ciudades.add("Paramaribo,sr");
        ciudades.add("Longyearbyen,sj");
        ciudades.add("Mbabane,sz");
        ciudades.add("Stockholm,se");
        ciudades.add("Bern,ch");
        ciudades.add("Damascus,sy");
        ciudades.add("Taipei,tw");
        ciudades.add("Dushanbe,tj");
        ciudades.add("Dodoma,tz");
        ciudades.add("Bangkok,th");
        ciudades.add("Lome,tg");
        ciudades.add("None,tk");
        ciudades.add("Nuku'alofa,to");
        ciudades.add("Port of Spain,tt");
        ciudades.add("Tunis,tn");
        ciudades.add("Ankara,tr");
        ciudades.add("Ashgabat,tm");
        ciudades.add("Grand Turk,tc");
        ciudades.add("Funafuti,tv");
        ciudades.add("London,uk");
        ciudades.add("Washington,us");
        ciudades.add("None,um");
        ciudades.add("Kampala,ug");
        ciudades.add("Kiev,ua");
        ciudades.add("Abu Dhabi,ae");
        ciudades.add("Montevideo,uy");
        ciudades.add("Tashkent,uz");
        ciudades.add("Port Vila,vu");
        ciudades.add("Vatican City,va");
        ciudades.add("Caracas,ve");
        ciudades.add("Hanoi,vn");
        ciudades.add("Road Town,vg");
        ciudades.add("Charlotte Amalie,vi");
        ciudades.add("Mata-Utu,wf");
        ciudades.add("El Aaiun,eh");
        ciudades.add("San'a,ye");
        ciudades.add("Lusaka,zm");
        ciudades.add("Harare,zw");

    }
}
