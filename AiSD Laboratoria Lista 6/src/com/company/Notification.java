package com.company;

import java.util.Iterator;

public class Notification {
    private Notification next;
    private OneWayLinkedListWithHead<Notification> ownQueue;
    private Client client;
    private Order order;

    public Notification( Client client, Order order) {
        this.client = client;
        ownQueue = client.getClientsQueue();
        Iterator<Notification> iterator = ownQueue.iterator();
        while (iterator.hasNext()) {
            Notification notification = iterator.next();
            if (notification == this){
                next = ownQueue.get(ownQueue.indexOf(notification)+1);
            }
        }
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public Client getClient() {
        return client;
    }
}
