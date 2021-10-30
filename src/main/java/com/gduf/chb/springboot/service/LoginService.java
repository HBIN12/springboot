package com.gduf.chb.springboot.service;


import com.gduf.chb.springboot.bean.Hospital;
import com.gduf.chb.springboot.bean.Login;
import com.gduf.chb.springboot.bean.Staff;

public interface LoginService {
    Login logincheck(String id, String password);
    int userregister(String id, String password);
    int staffregister(String id, String password, String code);
    boolean checkid(String id);
    boolean checkcode(String code);
    int insertstaff(Staff staff);
    Hospital gethospitalbycode(String code);
}
