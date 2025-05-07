package org.jpa.chatentiemporeal.config;

public class HelloMessage {

    private String name;
    private String text;

    public HelloMessage() {
    }

    public HelloMessage(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public String getMessage() {
        if (text == null || text.isEmpty()) {
            return "Hello!";
        } else {
            return text;
        }
    }
}