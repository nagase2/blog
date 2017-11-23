package com.nagase.experiment
import com.hoge.spocktest.*

import spock.lang.*



class StringFilterSpec extends Specification{

    private StringFilter instance;

    def setup() {
        instance = new StringFilter()
    }

	

    def "フィルタに一致するパターンのテスト"() {
        expect:
        instance.doFilter(a) == true
		
        where:
		a | b
        "a_flg_3" | 2
		"a_flg_223" | 2
        "a_flg_x" | 2
        "xxxx_33x_xxxx_flg" | 2
        "xxxx_flg_xxx" | 2
        "xxxx_flg_" | 2
        "flg_xxxxxxxx" | 2
        "_flg" | 2
        "flg_" | 2
    }

    def "フィルターに一致しないパターンのテスト"() {
        expect:
        instance.doFilter(a) == false

        where:
		a | b
        "a_fleg" | 2
		"flga_fklflg_ge" | 2
		"a_fl_gee" | 2
        "a_fl_gee" | 2
        "aflgflggee" | 2
        "aflg_ee" | 2
        "flgxxjdskf" | 2
        "xxxxflg_xx" | 2
        "xxxx_flgxxxxx" | 2

    }
}
