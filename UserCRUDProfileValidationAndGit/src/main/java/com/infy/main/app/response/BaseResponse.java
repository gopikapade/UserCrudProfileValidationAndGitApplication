package com.infy.main.app.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
	
	private int responsestatus;
	private Date date;
	private String responsemessage;
	private T body;

}
