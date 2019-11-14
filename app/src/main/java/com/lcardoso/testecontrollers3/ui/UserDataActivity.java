package com.lcardoso.testecontrollers3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.lcardoso.testecontrollers3.R;
import com.lcardoso.testecontrollers3.contract.UserDataContract;
import com.lcardoso.testecontrollers3.model.User;
import com.lcardoso.testecontrollers3.presenter.UserDataPresenter;

public class UserDataActivity extends AppCompatActivity implements UserDataContract.View {

    private TextView textName, textLastName, textPhone, textMobilePhone, textCpf, textRg, textSchool, textAdress,
            textNeighborhood, textState;
    private Button btnDone;
    private UserDataContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        presenter = new UserDataPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void setTextViews() {
        textName = findViewById(R.id.textName);
        textLastName = findViewById(R.id.textLastName);
        textPhone = findViewById(R.id.textPhone);
        textMobilePhone = findViewById(R.id.textMobilePhone);
        textCpf = findViewById(R.id.textCpf);
        textRg = findViewById(R.id.textRg);
        textSchool = findViewById(R.id.textSchool);
        textAdress = findViewById(R.id.textAdress);
        textNeighborhood = findViewById(R.id.textNeighborhood);
        textState = findViewById(R.id.textState);
    }

    @Override
    public void setButton() {
        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDoneButtonClicked();
            }
        });
    }

    @Override
    public void setFormData() {
        //       Bundle data = getIntent().getExtras();
        //       User user = (User) data.getSerializable("user");
        User user = getIntent().getExtras().getParcelable("user");

        textName.setText(user.getName());
        textLastName.setText(user.getLastName());
        textPhone.setText(user.getPhone());
        textMobilePhone.setText(user.getMobilePhone());
        textCpf.setText(user.getCpf());
        textRg.setText(user.getRg());
        textSchool.setText(user.getSchool());
        textAdress.setText(user.getAdress());
        textNeighborhood.setText(user.getNeighborhod());
        textState.setText(user.getState());
    }

    @Override
    public void showSnackbar(String message) {
        View view = findViewById(R.id.userDataContainer);
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("Concluir", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isRegisterValid();
                    }
                })
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }

    public void isRegisterValid(){
        Intent intent = new Intent(UserDataActivity.this, UserFormActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}