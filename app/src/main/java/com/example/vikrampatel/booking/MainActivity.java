package com.example.vikrampatel.booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener{
    /** ButterKnife Code **/
    @NotEmpty
    @BindView(R.id.buying)
    RadioButton buying;
    @NotEmpty
    @BindView(R.id.rent)
    RadioButton rent;
    @NotEmpty
    @BindView(R.id.fname)
    EditText fname;
    @Length(max = 10,min = 10 ,message = "mobile number must have 10 digits")
    @BindView(R.id.mobile)
    EditText mobile;
    @NotEmpty
    @BindView(R.id.email)
    EditText email;
    @NotEmpty
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.gender1)
    TextView gender1;
    @NotEmpty
    @BindView(R.id.male1)
    RadioButton male1;
    @NotEmpty
    @BindView(R.id.female1)
    RadioButton female1;
    @BindView(R.id.flat_type)
    TextView flatType;
    @NotEmpty
    @BindView(R.id.bhk1)
    RadioButton bhk1;
    @NotEmpty
    @BindView(R.id.bhk2)
    RadioButton bhk2;
    @NotEmpty
    @BindView(R.id.bhk3)
    RadioButton bhk3;
    @BindView(R.id.register)
    Button register;
    Validator validator;
    /** ButterKnife Code **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        validator= new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.register)
    void register(){
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        Intent i = new Intent(MainActivity.this,Register_main.class);
        startActivity(i);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
// validation fail

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);


            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
            }
        }
    }
}