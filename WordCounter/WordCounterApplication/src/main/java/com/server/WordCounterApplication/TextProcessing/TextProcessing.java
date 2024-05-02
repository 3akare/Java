package com.server.WordCounterApplication.TextProcessing;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TextProcessing {
    String message;

    public TextProcessing(){};

    public TextProcessing(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCharacters(){
        return message.length();
    }

    public Integer getWhiteSpaces(){
        int count = 0;
        for (int idx = 0; idx < message.length(); idx++){
            if (message.charAt(idx) == ' ') count++;
        };
        return count;
    }

    public Integer getWords(){
        return message.split("[\n\t\u200E ]").length;
    }

    public Integer getParagraphs(){
        int count = 0;
        for (int idx = 0; idx < message.length(); idx++){
            if (message.charAt(idx) == '\n' && (message.charAt(idx + 1) == '\n' || message.charAt(idx + 1) == ' ')) count++;
        }
        return count;
    }

    public Integer getPages(){
        return message.length() / 2000;
    }

    public Integer sentence(){
        int count = 0;
        for (int idx = 0; idx < message.length(); idx++){
            if ((message.charAt(idx) == '.' || message.charAt(idx) == '?' || message.charAt(idx) == '!') && message.charAt(idx + 1) == ' ') count++;
        }
        return count;
    }

    public Integer reading(){
        return getCharacters()/200;
    }

    public Integer writing() {
        return  getCharacters()/40;
    }

    public Map<String,Integer> outPut(){
        Map<String,Integer> json = new HashMap<>();
        json.put("characters", getCharacters());
        json.put("words", getWords());
        json.put("whitespaces", getWhiteSpaces());
        json.put("paragraph", getParagraphs());
        json.put("pages", getPages());
        json.put("sentences", sentence());
        json.put("writing", writing());
        json.put("reading", reading());
        return json;
    }
}
