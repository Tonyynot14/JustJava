package com.example.atwad.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 2;
    boolean whipped;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(5);
        String priceMessage = "Name: Tony Wade\n";
        if(checkCream())
        {
            priceMessage+= "Add whipped cream\n";
        }
        priceMessage+="Total: $" + (price) ;
        priceMessage +="\nThank you!";

        displayMessage(priceMessage);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);

    }
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int stuff) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + stuff);
    }

// displays price
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message)
    {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private int calculatePrice(int priceOfOneCup)
    {
        return quantity*priceOfOneCup;
    }
    private boolean checkCream()
    {
        CheckBox whippedBox = findViewById(R.id.whipped_cream_checkBox);
        if(whippedBox.isChecked())
        {
            whipped=true;
        }
        else{
            whipped=false;
        }
        return whipped;
    }
}
