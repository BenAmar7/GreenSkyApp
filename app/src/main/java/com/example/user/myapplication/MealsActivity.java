package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MealsActivity extends AppCompatActivity {
    private User logedInUser;
    private Flight flight;
    private ArrayList<String> selection = new ArrayList<String>();

    private void init() {
        logedInUser = (User) getIntent().getSerializableExtra("user");
        flight = (Flight) getIntent().getSerializableExtra("flight");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        init();
        calculateMealPoints();

    }

    private void calculateMealPoints() {
    }

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.meat_i1:

                if (checked) {
                    selection.add("Meat");
                } else {
                    selection.remove("Meat");

                }
                break;

            case R.id.meat_i2:

                if (checked) {
                    selection.add("Rice");
                } else {
                    selection.remove("Rice");

                }
                break;

            case R.id.meat_i3:

                if (checked) {
                    selection.add("Veggies");
                } else {
                    selection.remove("Veggies");

                }
                break;

            case R.id.regular_i1:

                if (checked) {
                    selection.add("Chicken");
                } else {
                    selection.remove("Chicken");

                }
                break;

            case R.id.regular_i2:

                if (checked) {
                    selection.add("Pasta");
                } else {
                    selection.remove("Pasta");

                }
                break;

            case R.id.regular_i3:

                if (checked) {
                    selection.add("Sauce");
                } else {
                    selection.remove("Sauce");

                }
                break;

            case R.id.vegan_i1:

                if (checked) {
                    selection.add("Tofu");
                } else {
                    selection.remove("Tofu");

                }
                break;

            case R.id.vegan_i2:

                if (checked) {
                    selection.add("Lettuce");
                } else {
                    selection.remove("Lettuce");

                }
                break;

            case R.id.vegan_i3:

                if (checked) {
                    selection.add("Almonds");
                } else {
                    selection.remove("Almonds");

                }
                break;

        }
    }

    public void finalSelection(View view) {
        String final_food_selection = "";
        for (String Selection : selection) {
            final_food_selection = final_food_selection + Selection + "\n";
        }

    }
}
