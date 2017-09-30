package com.naggi.springboot.lazyinit.jpa.data;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne()
    @JoinColumn(name="family_id")
    @JsonIgnore
    private Family family;

    private String nonsenseField = "";
    
//    /**
//     * 親から子への参照。これは消すこともできる。
//     */
//    @OneToMany(mappedBy = "jobMember") //mappedByでは、子の変数名を指定する。
//    private List<Job> jobs = new ArrayList<Job>();

    

}
