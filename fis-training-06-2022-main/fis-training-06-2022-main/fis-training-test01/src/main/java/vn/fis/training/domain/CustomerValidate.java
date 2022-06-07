package vn.fis.training.domain;

import vn.fis.training.exception.InvalidCustomerException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;

public class CustomerValidate {
    public String name(){
        String result = " ";
        if (name()==null && name().trim().length()==0 && name().trim().length() < 5 && name().trim().length() >50){
            throw new InvalidCustomerException("Customer Name is empty");
        }
        name().trim();
        String [] arr = name().split(" ");
        for (String s: arr) {
            result += String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1)+" ";
        }
        return result.substring(0,result.length()-1);
    }
    public LocalDate birthDay(){
        int dayNow = LocalDate.now().getYear();
        int dayBirtDay = birthDay().getYear();
        if (dayNow - dayBirtDay < 10){
            throw new InvalidCustomerException("Customer Birth day is empty");
        }else {
            return birthDay();
        }
    }
}
