package com.nagase.experiment;

public class StringFilter {

    public StringFilter() {
        // TODO Auto-generated constructor stub
    }

    
    public boolean doFilter(String str) {
        //xxx_flg or flg+数字列 or xxxx_flg_xxx or 
        return str.toLowerCase().matches("(flg_.*|.*_flg_.*|.*_flg)$");
    }
    
   // matches(".*_(flg|flg_\\d+)$")) 

}
