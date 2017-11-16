package com.nagase.experiment
import spock.lang.*

import com.hoge.spocktest.*
import com.naggi.springboot.lazyinit.service.heavyservice.HeavyLoadBean



class SpockGrammerExperiment extends Specification{

	private StringFilter instance;
	//下記のように書くことで、このSpecificationの中でインスタンスをを共有できる。（インスタンス化は最初の一回だけ）
	@Shared private HeavyLoadBean hlb = new HeavyLoadBean("TEST",2);
	@Shared HeavyLoadBean hlb2;

	def setupSpec() {
		println "setup spec"
		hlb2 = new HeavyLoadBean("TEST2",2);
	}
	def setup() {
		instance = new StringFilter()
		
	}



	def "時間のかかるBeanのロード１"() {
		expect:
		instance.doFilter(a) == true
		println hlb.getId()+b;
		


		where:
		a | b
		"a_flg_3" | 8
		"a_flg_3" | 2
		"a_flg_3" | 5
	}

	def "時間のかかるBeanのロード２"() {
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
