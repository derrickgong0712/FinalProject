package com.example.finalproject;

public class Person {
    /** weight of a person. */
    private double weight;

    /** height of a person. */
    private double height;

    /** age of a person. */
    private int age;

    /** construct a person object. */
    Person(double setweight, double setheight, int setage) {
        weight = setweight;
        height = setheight;
        age = setage;
    }

    /**
     * calculate a person's BMI.
     * @return BMI value.
     */
    public double getBMI() {
        double bmi = weight / (height * height);
        return bmi;
    }

    /**
     * get a person's weight status;
     * @param bmi bmi index
     * @return weight status.
     */
    public int weightstatus(double bmi) {
        if (bmi < 18.5) {
            return 0;
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return 1;
        } else if (bmi >= 24.9 && bmi < 29.9) {
            return 2;
        }
        return 3;
    }
}
