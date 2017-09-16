package com.naggi.springboot.lazyinit.data;

public class Greeting {

    private  long id=1;
    private  String content="rest";
    private String message;
    
    public Greeting(){
    	System.out.println("greeting's constracte has been called.");
    }


    public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }


    public void setId(long id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}