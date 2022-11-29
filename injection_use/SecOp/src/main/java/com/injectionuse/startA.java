package com.injectionuse;

import com.injectionuse.dao.LinkedDao;

public class startA {
    public static void main(String[] args) {
        LinkedDao linkedDao = new LinkedDao();
        int id = 1;
//        String sql = "select * from Student where id = " + 1 + " or name =" + "'pan'";
        String sql = "select * from Student where id=?";
        int use = linkedDao.exeUp(sql, id);
        System.out.println(use);
    }
}
