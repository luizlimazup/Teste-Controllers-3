package com.lcardoso.testecontrollers3.presenter;

import com.lcardoso.testecontrollers3.contract.UserContract;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;

    public UserPresenter() {
    }

    @Override
    public void onStart(UserContract.View view) {
        this.view = view;
        view.setEditTexts();
        view.setSpinners();
        view.setButtons();
        view.setMasks();
    }

    @Override
    public void onStop() {
        view = null;
    }

    @Override
    public void onResetButtonClicked() {
        view.clearForm();
    }

    @Override
    public void onSendButtonClicked() {
        switch (view.isValidForm()) {
            case 0:
                view.navigateToNextScreen();
                break;
            case 1:
                view.showMessage("Nome");
                break;
            case 2:
                view.showMessage("Sobrenome");
                break;
            case 3:
                view.showMessage("Telefone");
                break;
            case 4:
                view.showMessage("Celular");
                break;
            case 5:
                view.showMessage("CPF");
                break;
            case 6:
                view.showMessage("RG");
                break;
            case 7:
                view.showMessage("Escolaridade");
                break;
            case 8:
                view.showMessage("Endereço");
                break;
            case 9:
                view.showMessage("Bairro");
                break;
            case 10:
                view.showMessage("Estado");
                break;
            case 11:
                view.showMessage("Senha");
                break;
            case 12:
                view.showMessageP("As senhas não correspondem");
                break;
        }
    }
}
