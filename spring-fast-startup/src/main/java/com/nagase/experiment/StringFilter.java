package com.nagase.experiment;

public class StringFilter {

    public StringFilter() {
        // TODO Auto-generated constructor stub
    }

    
    public boolean doFilter(String str) {

        return str.matches(".*_(flg|flg_\\d+).*$");
    }

}
