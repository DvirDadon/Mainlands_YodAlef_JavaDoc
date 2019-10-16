package com.example.mainlands_yodalef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Countries_Cap_Pop extends AppCompatActivity implements AdapterView.OnItemClickListener {
    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @param Countries This array suppose to show the Countries of the mainland the user picked. It's also showing the capital city and the population of the country that the user choose.
     * @param check This is integer to check which mainland the user Selected.
     */
    String[][] Countries = new String[3][7];
    ListView lv2;
    TextView capital,population;
    int check;

    /**
     * @author Dvir Dadon
     * @Since 16/10/2019
     * @return this is a main method that checking which mainland the user picked and showing him the countries of that mainland.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries__cap__pop);
        Intent gi =getIntent();
        lv2 = (ListView)findViewById(R.id.lv2);
        lv2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv2.setOnItemClickListener(this);
        capital = (TextView)findViewById(R.id.capital);
        population=(TextView)findViewById(R.id.population);
        check=gi.getIntExtra("Yabashet",-1);
        if (check==0){
            Countries=new String[][]{{"United States","Brazil","Mexico","Argentina","Colombia","Canada","Chile"},
                    {"Capital City: Washington D.C","Capital City: Brasillia","Capital City: Mexico City","Capital City: Buenos Aires,","Capital City: Bogota","Capital City: Ottawa","Capital City: Santiago"},
                    {"Population: 327.M","Population: 209.3M","Population: 129.2M","Population: 44.27M","Population: 49.07M","Population: 37.06M","Population: 18.05M"}};
        }

        else if(check==1){
            Countries=new String[][]{{"Nigeria","Marrocco","Ghana","Ethiopia","Sudan","Uganda","Madagaskar"},
                    {"Capital City: Abuja","Capital City: Rabat","Capital City: Accra","Capital City: Addis Abada","Capital City: Khartoum","Capital City: Kampala","Capital City: Antanarivo"},
                    {"Population: 190.09M","Population: 35.74M","Population: 28.83M","Population: 105M","Population: 40.53M","Population: 42.86M","Population: 25.57M"}};
        }

        else if (check==2){
            Countries=new String[][]{{"India","Japan","China","Israel","Thailand","Hong Kong","Vietnam"},
                    {"Capital City: New Delhi","Capital City: Tokyo","Capital City: Beijing","Capital City: Jerusalem","Capital City: Bangkok","Capital City: Victoria","Capital City: Hanoi"},
                    {"Population: 1.339B","Population:126.8M ","Population: 1.386B","Population: 8.7M","Population: 69M","Population: 7.392M","Population: 95.54M"}};
        }
        else if (check==3){
            Countries=new String[][]{{"Germany","French","Spain","Greece","Italy","Poland","Belgium"},
                    {"Capital City: Berlin","Capital City: Paris","Capital City: Madrid","Capital City: Athens","Capital City: Rome","Capital City: Warsaw","Capital City: Brussels"},
                    {"Population: 82.8M","Population: 67M","Population: 46.72M","Population: 10.77M","Population: 60.59M","Population: 38.43M","Population: 11.35M"}};
        }
        ArrayAdapter<String> adp =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Countries[0]);
        lv2.setAdapter(adp);
    }

    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @return this method is returns to the first activity
     */
    public void BackToYabashot(View view) {
        finish();
    }

    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @param parent this to detect which listview the user picked.
     * @param view The element that has been picked.
     * @param position It to show the Capital city and population of the country the user picked.
     * @param id Shows which row the user picked.
     * @return This method shows the user the Capital city and the population of the mainland that the user picked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        capital.setText(Countries[1][position]);
        population.setText(Countries[2][position]);
    }
}
