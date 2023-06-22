package com.mse.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorPage {

	private LocalDateTime date;
	private String msg;
	private int code;

	/*public ErrorPage(LocalDateTime dateTime, String message, int errorCode) {
		// Constructor implementation
	}
	*/
}
