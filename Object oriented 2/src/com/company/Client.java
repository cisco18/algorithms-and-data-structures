package com.company;

public class Client {
    private OneWayLinkedListWithHead<Notification> clientsQueue;
    private String nameOfTheClient;

    public Client(String nameOfTheClient){
        clientsQueue = new OneWayLinkedListWithHead<>();
        this.nameOfTheClient = nameOfTheClient;
    }

    public OneWayLinkedListWithHead<Notification> getClientsQueue() {
        return clientsQueue;
    }

    public String getNameOfTheClient() {
        return nameOfTheClient;
    }

    public void setClientsQueue(OneWayLinkedListWithHead<Notification> clientsQueue) {
        this.clientsQueue = clientsQueue;
    }
}
