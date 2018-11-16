package com.example.atwad.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 2;
    boolean whipped;
    boolean chocolate;
    /**
     * This method is called when the order button is clicked.
     */


    public void submitOrder(View view) {
        int price = calculatePrice(5);
        EditText nameText = findViewById(R.id.name);
        String name =(String) nameText.getText().toString();
        String priceMessage = getString(R.string.order_summary_name,name)+"\n";
        if(checkCream())
        {
            priceMessage+= "Add whipped cream\n";
        }
        if(checkChocolate())
        {
            priceMessage+= "Add Chocolate\n";

        }
        priceMessage+=getString(R.string.quantity) +": "+quantity;
        priceMessage+="\nTotal: "+ NumberFormat.getCurrencyInstance().format(price);
        priceMessage +="\n"+getString(R.string.thankYou);

        displayMessage(priceMessage);
        /*Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/
    }

    public void increment(View view) {
        if (quantity<100)
        {
            quantity++;

        }
        else
        {
            Toast.makeText(this, "Cannot go above 100 cups of coffee", Toast.LENGTH_SHORT).show();
        }
        displayQuantity(quantity);

    }
    public void decrement(View view) {
        if (quantity>1)
        {
            quantity--;

        }
        else
        {
            Toast.makeText(this, "Cannot go under 1 cup of coffee", Toast.LENGTH_SHORT).show();
        }
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
        int price=quantity*priceOfOneCup;
        if (checkChocolate()){
            price+=2*quantity;
        }
        if (checkCream()){
            price+=1*quantity;
        }
        return price;

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
    private boolean checkChocolate()
    {
        CheckBox checkChocolate = findViewById(R.id.chocolate_checkBox);
        if(checkChocolate.isChecked())
        {
            chocolate=true;
        }
        else{
            chocolate=false;
        }
        return chocolate;
    }
}
