package com.lcardoso.testecontrollers3.contract;

public interface UserDataContract {

    interface View {
        void setTextViews();
        void setButton();
        void setFormData();
        void showSnackbar(String message);
    }

    interface Presenter {
        void onStart();
        void onStop();
        void onDoneButtonClicked();
    }
}
