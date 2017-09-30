package com.naggi.springboot.lazyinit.jpa.data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double salery;
    private String jobDescr;
    
    /**
     * 子から親の参照。実際にこのカラムはこのテーブルに存在する。これがないと、親からの関連も引くことができない
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Person jobMember;

 
}
