package kr.co.tjeit.bookstore.datas;

import java.io.Serializable;

/**
 * Created by tjoeun on 2017-07-25.
 */

public class Customer implements Serializable {
    public String name;
    public String phoneNum;
    public String email;

    public Customer(){};

    public Customer(String inputName, String inputPhoneNum, String inputEmail){
        this.name = inputName;
        this.phoneNum = inputPhoneNum;
        this.email = inputEmail;
    }

    @Override
    public String toString() {
        String str=this.name+" \n "+this.phoneNum;
        return str;
    }
}
