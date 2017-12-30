package com.example.amandeepaujla.lab5_amandeep_jishnu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CusineActivity extends AppCompatActivity {


    private RadioGroup rg;
    int selectedValueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusine);
        rg = (RadioGroup) findViewById(R.id.radio_Cuisine_group);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                selectedValueId =rg.indexOfChild(findViewById(checkedId));
                    }
                });
               }


    public void openRestaurants(View view) {

        Intent intent = new Intent(this, RestaurantActivity.class);
        intent.putExtra("selectedCuisine", selectedValueId);
        startActivity(intent);

    }


}


