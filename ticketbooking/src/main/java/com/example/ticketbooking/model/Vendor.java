package com.example.ticketbooking.model;

import com.example.ticketbooking.enums.UserType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Document(collection = "vendors")
public class Vendor extends User{
    private int totNumOfTicketReleased;
//    private Date lastReleasedTime;
    private String lastReleasedTime;

    public Vendor(String username, String email, String password) {
        super(username, email, password, UserType.VENDOR);
        this.totNumOfTicketReleased = 0;    //total number of tickets released by vendor;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.lastReleasedTime = myDateObj.format(myFormatObj); // 2024-12-01T00:00:00;

    }

    public String getLastReleasedTime() {
        return lastReleasedTime;
    }

    public void setLastReleasedTime(String lastReleasedTime) {
        this.lastReleasedTime = lastReleasedTime;
    }

    public int getTotNumOfTicketReleased() {
        return totNumOfTicketReleased;
    }

    public void setTotNumOfTicketReleased(int totNumOfTicketReleased) {
        this.totNumOfTicketReleased = totNumOfTicketReleased;
    }
}
