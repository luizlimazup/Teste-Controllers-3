package com.lcardoso.testecontrollers3.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user = new User();

    @Test
    public void when_getName() {
        user.setName("name");
        String name = user.getName();
        assertEquals("name", name);
    }

    @Test
    public void when_getLastName() {
        user.setLastName("lastname");
        String lname = user.getLastName();
        assertEquals("lastname", lname);
    }

    @Test
    public void when_getPhone() {
        user.setPhone("123");
        String phone = user.getPhone();
        assertEquals("123", phone);
    }

    @Test
    public void when_getMobilePhone() {
        user.setMobilePhone("123");
        String mobile = user.getMobilePhone();
        assertEquals("123", mobile);
    }

    @Test
    public void when_getCpf() {
        user.setCpf("123");
        String cpf = user.getCpf();
        assertEquals("123", cpf);
    }

    @Test
    public void when_getSchool() {
        user.setSchool("Ensino Superior");
        String school = user.getSchool();
        assertEquals("Ensino Superior", school);
    }

    @Test
    public void when_getAdress() {
        user.setAdress("rua");
        String adress = user.getAdress();
        assertEquals("rua", adress);
    }

    @Test
    public void when_getNeighborhod() {
        user.setNeighborhod("Guaianazes");
        String neighborhood = user.getNeighborhod();
        assertEquals("Guaianazes", neighborhood);
    }

    @Test
    public void when_getState() {
        user.setState("São Paulo");
        String state = user.getState();
        assertEquals("São Paulo", state);
    }
}