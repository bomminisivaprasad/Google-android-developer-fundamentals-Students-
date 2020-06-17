package com.example.roomdatabasewithlivedata;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AndroidStudents_1")
public class Student {

    String Name;

    @PrimaryKey @NonNull
    String RollNumber;

    String MobileNUmber;

    String MailID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @NonNull
    public String getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(@NonNull String rollNumber) {
        RollNumber = rollNumber;
    }

    public String getMobileNUmber() {
        return MobileNUmber;
    }

    public void setMobileNUmber(String mobileNUmber) {
        MobileNUmber = mobileNUmber;
    }

    public String getMailID() {
        return MailID;
    }

    public void setMailID(String mailID) {
        MailID = mailID;
    }
}
