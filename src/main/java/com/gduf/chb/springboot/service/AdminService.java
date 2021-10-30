package com.gduf.chb.springboot.service;


import com.gduf.chb.springboot.bean.Hospital;
import com.gduf.chb.springboot.bean.Login;

import java.util.List;

public interface AdminService {
    //医院信息管理
    List<Hospital> getallhospital();
    int deletecthospital(String hospitalnum);
    int inserthosptital(Hospital hospital);
    int updatehospital(Hospital hospital);
    //修改登录信息
    List<Login> getalllogin();
    Login selectlogin(String id);
    int delectlogin(String id);
    int  insertlogin(Login login);
    int updatelogin(Login login);

}
