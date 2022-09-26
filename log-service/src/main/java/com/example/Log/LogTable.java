package com.example.Log;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class LogTable {
	@Id
	@GeneratedValue
	private Long id;
	@Lob
    private String name;

	public LogTable(String name){
		this.name = name;
	}
}
