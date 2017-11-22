package com.nagase.experiment
import com.hoge.spocktest.*

import spock.lang.*



class NextValSpec extends Specification{

    
    def setup() {
        
        //nvg = new NextValGenerator()
    }

    def "xxxxx"() {
        setup:
        //NextValGenerator nvg = Mock()
        def nvg = Mock(NextValGenerator.class)
        
        when:
        println(nvg.getNextVal())
        
        then:
        1 * nvg.getNextVal() >> 23
        println("aa")
  

    }
    

}
