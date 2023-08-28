package com.example.contact_database_project;

public class ContactList_Model {
    private int id;
    private String name;
    private String number;


    public ContactList_Model(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ContactList_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + number+ '\'' +
                '}';
    }
}
