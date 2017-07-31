package sg.edu.rp.c346.eventregistration;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText size;
    EditText day;
    EditText time;
    CheckBox SK;
    Button reset;
    Button reserve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editTextName);
        phone=(EditText)findViewById(R.id.editTextPhone);
        size=(EditText)findViewById(R.id.editTextSize);
        day=(EditText)findViewById(R.id.editTextDay);
        time=(EditText)findViewById(R.id.editTextTime);
        SK=(CheckBox) findViewById(R.id.smoking);
        reset=(Button)findViewById(R.id.buttonReset);
        reserve=(Button)findViewById(R.id.buttonReserve);


        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        day.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog

                Calendar now = Calendar.getInstance();
                int year=now.get(Calendar.YEAR);
                int month=now.get(Calendar.MONTH);
                int dayOfMonth =now.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, dayOfMonth);

                myDateDialog.show();
            }
        });






        time.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        time.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                Calendar now = Calendar.getInstance();
                int hour=now.get(Calendar.HOUR_OF_DAY);
                int minute=now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog =new TimePickerDialog(MainActivity.this,myTimeListener,hour,minute,true);

                // TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                //       myTimeListener, 20, 00, true);

                myTimeDialog.show();
            }
        });



    }
}
