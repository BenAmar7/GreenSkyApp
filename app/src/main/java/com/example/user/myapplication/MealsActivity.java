package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MealsActivity extends AppCompatActivity {
    private User logedInUser;
    private Flight flight;
    private ArrayList<String> selection;
    private ArrayList<CheckBox> checkBoxList;

    private void init() {
        logedInUser = (User) getIntent().getSerializableExtra("logedInUser");
        flight = (Flight) getIntent().getSerializableExtra("flight");
        selection = new ArrayList<String>();
        checkBoxList = new ArrayList<CheckBox>();
        createCheckBoxList();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        init();
    }

    private void calculateMealPoints() {
        switch (selection.size()) {
            case 0:
                updatePoints(3);
                break;
            case 1:
                updatePoints(2);
                break;
            case 2:
                updatePoints(1);
                break;
            case 3:
                updatePoints(0);
                break;
        }
    }

    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.meat:
                if (checked) {
                    selection.add("Meat");
                } else {
                    selection.remove("Meat");
                }
                break;
            case R.id.meatballs:
                if (checked) {
                    selection.add("Tofu");
                } else {
                    selection.remove("Tofu");
                }
                break;


            case R.id.chicken:
                if (checked) {
                    selection.add("Sauce");
                } else {
                    selection.remove("Sauce");
                }
                break;

            case R.id.egg:
                if (checked) {
                    selection.add("Pasta");
                } else {
                    selection.remove("Pasta");
                }
                break;

            case R.id.fish:
                if (checked) {
                    selection.add("Lettuce");
                } else {
                    selection.remove("Lettuce");
                }
                break;

            case R.id.toast:
                if (checked) {
                    selection.add("Toast");
                } else {
                    selection.remove("Toast");
                }
                break;

            case R.id.tofu:
                if (checked) {
                    selection.add("Tofu");
                } else {
                    selection.remove("Tofu");
                }
                break;


            case R.id.lentil_patties:
                if (checked) {
                    selection.add("lentil patties");
                } else {
                    selection.remove("lentil patties");
                }
                break;


            case R.id.eggplant_in_tehina:
                if (checked) {
                    selection.add("eggplant in tehina");
                } else {
                    selection.remove("eggplant in tehina");
                }
                break;

            case R.id.vegetable_Salad:
                if (checked) {
                    selection.add("Vegetable Salad");
                } else {
                    selection.remove("Vegetable Salad");
                }
                break;

            case R.id.rice:
                if (checked) {
                    selection.add("Rice");
                } else {
                    selection.remove("Rice");
                }
                break;

            case R.id.puree:
                if (checked) {
                    selection.add("Puree");
                } else {
                    selection.remove("Puree");
                }
                break;

            case R.id.bean:
                if (checked) {
                    selection.add("Bean");
                } else {
                    selection.remove("Bean");
                }
                break;
        }
        checkAndLock();
    }

    public void finalSelection(View view) {
        String final_food_selection = "";
        for (String Selection : selection) {
            final_food_selection = final_food_selection + Selection + "\n";
        }
        calculateMealPoints();
    }

    private void createCheckBoxList() {
        checkBoxList.add((CheckBox) findViewById(R.id.meat));
        checkBoxList.add((CheckBox) findViewById(R.id.meatballs));
        checkBoxList.add((CheckBox) findViewById(R.id.chicken));
        checkBoxList.add((CheckBox) findViewById(R.id.egg));
        checkBoxList.add((CheckBox) findViewById(R.id.fish));
        checkBoxList.add((CheckBox) findViewById(R.id.toast));
        checkBoxList.add((CheckBox) findViewById(R.id.tofu));
        checkBoxList.add((CheckBox) findViewById(R.id.lentil_patties));
        checkBoxList.add((CheckBox) findViewById(R.id.eggplant_in_tehina));
        checkBoxList.add((CheckBox) findViewById(R.id.vegetable_Salad));
        checkBoxList.add((CheckBox) findViewById(R.id.rice));
        checkBoxList.add((CheckBox) findViewById(R.id.puree));
        checkBoxList.add((CheckBox) findViewById(R.id.bean));
    }

    public void checkAndLock() {
        if (selection.size() >= 3) {
            for (CheckBox box : checkBoxList) {
                box.setEnabled(false);
            }
        } else {
            for (CheckBox box : checkBoxList) {
                box.setEnabled(true);
            }
        }
    }

    public void updatePoints(long points){
        flight.getPassengersList().put(logedInUser.getName(),points);
        logedInUser.setPoints(logedInUser.getPoints()+points);
        logedInUser.updateFlight(flight,points);
        DataBaseHelper.getInstance().getDB().child("users").child(logedInUser.getName()).setValue(logedInUser);
        DataBaseHelper.getInstance().getDB().child("flights").child(flight.getNumFlight()).setValue(flight);
        Intent na = new Intent(MealsActivity.this, InformationActivity.class);
        na.putExtra("logedInUser", logedInUser);
        na.putExtra("flight", flight);
        finish();
        startActivity(na);
    }
}
