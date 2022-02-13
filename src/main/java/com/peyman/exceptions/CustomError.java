package com.peyman.exceptions;

public class CustomError {

	private int code;
    private String message;

    
    public CustomError() {
		
	}

    public CustomError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
