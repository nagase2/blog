package com.nagase.experiment
import spock.lang.*

import com.hoge.spocktest.*



class StringFilterSpec extends Specification{

    private StringFilter instance;

    def setup() {
        instance = new StringFilter()
    }


    def "フィルタに一致するパターンのテスト"() {
        expect:
        instance.doFilter(a) == true

        where:
        "a_flg"
        "ss_flg_s"
        "x_flgxx"
        "aaxx_flg_aaa"
    }

    def "フィルターに一致しないパターンのテスト"() {
        expect:
        instance.doFilter(a) == false

        where:
        "a_fslg"
        "ss_f3lg_s"
        "x_fldgxx"
        "aaxx_fl3g_aaa"
    }
}
