package com.gduf.chb.springboot.service.Impl;


import com.gduf.chb.springboot.bean.Hospital;
import com.gduf.chb.springboot.bean.HospitalExample;
import com.gduf.chb.springboot.bean.Login;
import com.gduf.chb.springboot.bean.LoginExample;
import com.gduf.chb.springboot.mapper.HospitalMapper;
import com.gduf.chb.springboot.mapper.LoginMapper;
import com.gduf.chb.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    HospitalMapper hospitalMapper;
    @Autowired
    LoginMapper loginMapper;
    @Autowired
    public List<Hospital> getallhospital() {
        HospitalExample hospitalExample=new HospitalExample();
        HospitalExample.Criteria criteria = hospitalExample.createCriteria();
        criteria.andHospitalnumberIsNotNull();
        return hospitalMapper.selectByExample(hospitalExample);
    }

    @Override
    public int deletecthospital(String hosptitalnum) {
        return hospitalMapper.deleteByPrimaryKey(hosptitalnum);
    }

    @Override
    public int inserthosptital(Hospital hospital) {
        return hospitalMapper.insert(hospital);
    }

    @Override
    public int updatehospital(Hospital hospital) {
        return hospitalMapper.updateByPrimaryKey(hospital);
    }

    @Override
    public List<Login> getalllogin() {
        LoginExample loginExample=new LoginExample();
        LoginExample.Criteria criteria = loginExample.createCriteria();
        criteria.andIdIsNotNull();
        return loginMapper.selectByExample(loginExample);
    }

    @Override
    public Login selectlogin(String id) {
        return loginMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delectlogin(String id) {
        return loginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertlogin(Login login) {
        return loginMapper.insert(login);
    }

    @Override
    public int updatelogin(Login login) {
        return loginMapper.updateByPrimaryKey(login);
    }
}
