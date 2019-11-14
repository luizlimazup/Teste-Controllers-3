package com.lcardoso.testecontrollers3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String name, lastName, phone, mobilePhone,
            cpf, rg ,school, adress, neighborhod, state;

    public User() {
    }

    public User(String name, String lastName, String phone, String mobilePhone, String cpf, String rg, String school, String adress, String neighborhod, String state) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.cpf = cpf;
        this.rg = rg;
        this.school = school;
        this.adress = adress;
        this.neighborhod = neighborhod;
        this.state = state;
    }

    protected User(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        phone = in.readString();
        mobilePhone = in.readString();
        cpf = in.readString();
        rg = in.readString();
        school = in.readString();
        adress = in.readString();
        neighborhod = in.readString();
        state = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNeighborhod() {
        return neighborhod;
    }

    public void setNeighborhod(String neighborhod) {
        this.neighborhod = neighborhod;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(phone);
        dest.writeString(mobilePhone);
        dest.writeString(cpf);
        dest.writeString(rg);
        dest.writeString(school);
        dest.writeString(adress);
        dest.writeString(neighborhod);
        dest.writeString(state);
    }
}
