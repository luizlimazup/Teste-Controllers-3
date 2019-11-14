package com.lcardoso.testecontrollers3.contract;

import com.lcardoso.testecontrollers3.model.User;

public interface UserContract {

    interface View {
        void setEditTexts();
        void setSpinners();
        void setButtons();
        void navigateToNextScreen();
        User getFormData();
        void clearForm();
        int isValidForm();
        void showMessage(String message);
        void showMessageP(String message);
        void setMasks();
    }

    interface Presenter {
        void onStart(UserContract.View view);
        void onStop();
        void onResetButtonClicked();
        void onSendButtonClicked();
    }
}
