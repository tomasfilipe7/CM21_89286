package com.example.homework_1;

public class SpeedDial {
    String number;
    String name;

    public SpeedDial()
    {
        number = "";
        name = "";
    }

    public String getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public void setSD(String name, String number)
    {
        this.name = name;
        this.number = number;
    }
}
