package com.example.notesappoffline.model;

public class Topic {

    String topicName;
    String fileName;

    public Topic(String topicName, String fileName) {
        this.topicName = topicName;
        this.fileName = fileName;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getFileName() {
        return fileName;
    }
}
