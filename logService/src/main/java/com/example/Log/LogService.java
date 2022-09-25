package com.example.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

	@Autowired
	LogRepostiory logRepostiory;

	public void addToRepostiory(String loginput){

		LogTable logTable = new LogTable(loginput);

		logRepostiory.save(logTable);
	}
}
