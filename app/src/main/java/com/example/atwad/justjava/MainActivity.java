package com.example.atwad.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 2;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = quantity*5;
        String priceMessage="Total: $" + (price) ;
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
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
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
}
