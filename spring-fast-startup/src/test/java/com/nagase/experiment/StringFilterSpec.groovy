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
		a | b
        "a_flg" | 2
		"a_flg" | 2
		"a_flg" | 2
		
    }

    def "フィルターに一致しないパターンのテスト"() {
        expect:
        instance.doFilter(a) == false

        where:
		a | b
        "a_fleg" | 2
		"a_fklge" | 2
		"a_fl_gee" | 2
    }
}
