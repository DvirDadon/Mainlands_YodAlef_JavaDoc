package com.example.mainlands_yodalef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Mainland extends AppCompatActivity implements AdapterView.OnItemClickListener {
    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @param check this paramater is to check if the user choosed a mainland or no.
     * @param Yabashot This is array that shows the mainlands.
     */

    int check=-1;
    ListView lv;
    String[] Yabashot ={"America","Africa","Asia","Europe"};

    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @return This method show the ListView
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv =(ListView)findViewById(R.id.lv);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
        ArrayAdapter <String> adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Yabashot);
        lv.setAdapter(adp);
    }

    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @return this method moving to the next activity only if the user picked a mainland.
     */

    public void ToCountries(View view) {
        if(check==-1)
            Toast.makeText(this, "Choose a mainland", Toast.LENGTH_SHORT).show();
        else{
            Intent si = new Intent(this,Countries_Cap_Pop.class);
            si.putExtra("Yabashet",check);
            startActivity(si);
        }
    }

    /**
     * @author Dvir Dadon
     * @since 16/10/2019
     * @param parent this to detect which listview the user picked.
     * @param view The element that has been picked.
     * @param position It to show which mainland the user picked.
     * @param id Shows which row the user picked.
     * @return the method return toast that shows to the user which mainland he picked.
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        check=position;
        Toast.makeText(this, Yabashot[position], Toast.LENGTH_SHORT).show();
    }
}
