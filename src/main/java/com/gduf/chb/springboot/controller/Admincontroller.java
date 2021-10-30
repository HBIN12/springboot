package com.gduf.chb.springboot.controller;


import com.gduf.chb.springboot.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Admincontroller {
    @Autowired
    HospitalMapper hospitalMapper;

}
