package com.lcardoso.testecontrollers3.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lcardoso.testecontrollers3.R;
import com.lcardoso.testecontrollers3.contract.UserContract;
import com.lcardoso.testecontrollers3.model.User;
import com.lcardoso.testecontrollers3.presenter.UserPresenter;

public class UserFormActivity extends AppCompatActivity implements UserContract.View {

    private EditText etName, etLastName, etPhone, etMobilePhone, etCpf, etRg, etAdress, etNeighborhood,
            etPassword, etPasswordConfim;
    private Spinner spSchool, spState;
    private FloatingActionButton fabSend;
    private TextView txtReset;
    private User mUser;
    private UserContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        presenter = new UserPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onStart(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onStop();
    }

    @Override
    public void setEditTexts() {
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etMobilePhone = findViewById(R.id.etMobilePhone);
        etCpf = findViewById(R.id.etCpf);
        etRg = findViewById(R.id.etRg);
        etAdress = findViewById(R.id.etAdress);
        etNeighborhood = findViewById(R.id.etNeighborhood);
        etPassword = findViewById(R.id.etPassword);
        etPasswordConfim = findViewById(R.id.etPasswordConfim);
    }

    @Override
    public void setSpinners() {
        spSchool = findViewById(R.id.spSchool);
        spState = findViewById(R.id.spState);

        ArrayAdapter adapterSchool = ArrayAdapter.createFromResource(this, R.array.school, R.layout.spinner_item);
        adapterSchool.setDropDownViewResource(R.layout.spinner_dropdown);
        ArrayAdapter adapterState = ArrayAdapter.createFromResource(this, R.array.state, R.layout.spinner_item);
        adapterState.setDropDownViewResource(R.layout.spinner_dropdown);

        spSchool.setAdapter(adapterSchool);
        spState.setAdapter(adapterState);
    }

    @Override
    public void setButtons() {
       fabSend = findViewById(R.id.fabSend);
       fabSend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               presenter.onSendButtonClicked();
           }
       });

       txtReset = findViewById(R.id.txtReset);
       txtReset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               presenter.onResetButtonClicked();
           }
       });
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(UserFormActivity.this, UserDataActivity.class);
        intent.putExtra("user", getFormData());
        startActivity(intent);
    }

    @Override
    public User getFormData() {
        mUser = new User();

        mUser.setName(etName.getText().toString());
        mUser.setLastName(etLastName.getText().toString());
        mUser.setPhone(etPhone.getText().toString());
        mUser.setMobilePhone(etMobilePhone.getText().toString());
        mUser.setCpf(etCpf.getText().toString());
        mUser.setRg(etRg.getText().toString());
        mUser.setAdress(etAdress.getText().toString());
        mUser.setNeighborhod(etNeighborhood.getText().toString());
        mUser.setSchool(spSchool.getSelectedItem().toString());
        mUser.setState(spState.getSelectedItem().toString());

        return mUser;
    }

    @Override
    public void clearForm() {
        etName.getText().clear();
        etLastName.getText().clear();
        etPhone.getText().clear();
        etMobilePhone.getText().clear();
        etCpf.getText().clear();
        etRg.getText().clear();
        etAdress.getText().clear();
        etNeighborhood.getText().clear();
        spSchool.setSelection(0);
        spState.setSelection(0);
        etPassword.getText().clear();
        etPasswordConfim.getText().clear();
    }

    public Boolean invalidData(String data) {

        Boolean invalid = false;

        if (data.isEmpty() || data.equals(null)) {
            invalid = true;
        }
        return invalid;
    }

    public Boolean invalidSelectedItem(int i) {

        Boolean invalid = false;

        if (i == 0) {
            invalid = true;
        }
        return invalid;
    }

    public Boolean isValidPassword(String password, String confirm) {

        Boolean isValid = false;

        if (!password.equals(confirm) || password.isEmpty() || password.equals(null)
                || confirm.isEmpty() || confirm.equals(null)) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    public int isValidForm() {
        if (invalidData(etName.getText().toString())) {
            return 1;
        } else if (invalidData(etLastName.getText().toString())) {
            return 2;
        } else if (invalidData(etPhone.getText().toString()) || etPhone.length() < 13) {
            return 3;
        } else if (invalidData(etMobilePhone.getText().toString()) || etMobilePhone.length() < 14) {
            return 4;
        } else if (invalidData(etCpf.getText().toString()) || etCpf.length() < 14) {
            return 5;
        } else if (invalidData(etRg.getText().toString()) || etRg.length() < 12) {
            return 6;
        } else if (invalidSelectedItem(spSchool.getSelectedItemPosition())) {
            return 7;
        } else if (invalidData(etAdress.getText().toString())) {
            return 8;
        } else if (invalidData(etNeighborhood.getText().toString())) {
            return 9;
        } else if (invalidSelectedItem(spState.getSelectedItemPosition())) {
            return 10;
        } else if (invalidData(etPassword.getText().toString())) {
            return 11;
        } else if (isValidPassword(etPassword.getText().toString(),
                etPasswordConfim.getText().toString())) {
            return 12;
        } else {
            return 0;
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), "O Campo " + message + " é obrigatório", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showMessageP(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void setMasks() {
        //Create masks
        SimpleMaskFormatter pmf = new SimpleMaskFormatter("(NN)NNNN-NNNN");
        SimpleMaskFormatter mmf = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        SimpleMaskFormatter cmf = new SimpleMaskFormatter("NNN.NNN.NNN.NN");
        SimpleMaskFormatter rmf = new SimpleMaskFormatter("NN.NNN.NNN-N");

        //Create MaskText Watcher
        MaskTextWatcher mtwPhone = new MaskTextWatcher(etPhone, pmf);
        MaskTextWatcher mtwMobile = new MaskTextWatcher(etMobilePhone, mmf);
        MaskTextWatcher mtwCpf = new MaskTextWatcher(etCpf, cmf);
        MaskTextWatcher mtwRg = new MaskTextWatcher(etRg, rmf);

        //Set Masks
        etPhone.addTextChangedListener(mtwPhone);
        etMobilePhone.addTextChangedListener(mtwMobile);
        etCpf.addTextChangedListener(mtwCpf);
        etRg.addTextChangedListener(mtwRg);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Você realmente deseja sair?");
        alert.setCancelable(false)
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}