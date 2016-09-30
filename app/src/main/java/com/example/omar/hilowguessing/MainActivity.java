/**
 *  {Hi-Low Game!!}
 *  @omartohme {tohm0011@algonquinlive.com}
 */

package com.example.omar.hilowguessing;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String ABOUT_DIALOG_TAG="aboutAthr";

    private int theNumber = 1;
    private int triesNumber = 0;

    private int randomNum() {
        Random randomNumber = new Random();
        theNumber = randomNumber.nextInt(1000);
        triesNumber = 0;
        return theNumber;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberField = (EditText) findViewById(R.id.numberField);

        Button btn_guess = (Button) findViewById(R.id.GuessButton);
        btn_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myvalue= numberField.getText().toString();
                Log.i("TAG",myvalue);
                if ( myvalue.isEmpty() ) {
                    numberField.setError( "Enter Your Username" );
                    numberField.requestFocus();
                    return;
                }
                int convertNumber = Integer.parseInt(myvalue);
                triesNumber++;

                if(convertNumber == theNumber ) {
                    Toast.makeText( getApplicationContext(), "You got it!", Toast.LENGTH_LONG).show();
                    randomNum();
                }

                else if (convertNumber > theNumber) {
                    Toast.makeText( getApplicationContext(), "Too high!!", Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText( getApplicationContext(), "Too low!!", Toast.LENGTH_LONG).show();
                }



            }
        });

        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                randomNum();
                Toast.makeText( getApplicationContext(), "Cleared the Number", Toast.LENGTH_LONG).show();

            }
        });

        Button hintButton = (Button) findViewById(R.id.resetButton);
        hintButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText( getApplicationContext(), String.valueOf(theNumber) , Toast.LENGTH_LONG).show();
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // TODO: add this method to handle when the user selects a menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

