package com.naggi.springboot.lazyinit.jpa.data;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	// オブジェクトが見つからなかった時にエラーを発生させない。
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "owner_id")
	// @JsonIgnore //Jsonのシリアライズ対象にしたくない場合はコレをつける。
	private Person owner;
	private String summary;
	private String description;
}