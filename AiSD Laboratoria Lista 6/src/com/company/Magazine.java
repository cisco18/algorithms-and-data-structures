package com.company;


public class Magazine {
    OneWayLinkedListWithHead<ElementM> queue;
    private double gain;

    public Magazine() {
        queue = new OneWayLinkedListWithHead<ElementM>();
        gain = 0;
    }

    public void process() {
        while (queue.size() > 0) {
            double gainNow = 0;
            ElementM e = queue.dequeue();
            Client client = e.getNotification().getClient();
            gain += e.getNotification().getOrder().getPrice() * e.getNotification().getOrder().getQuantity();
            gainNow += e.getNotification().getOrder().getPrice() * e.getNotification().getOrder().getQuantity();
            OneWayLinkedListWithHead<Notification> clientsQueue = client.getClientsQueue();
            while (clientsQueue.size() != 0) {
                Notification notification = clientsQueue.dequeue();
                gainNow += notification.getOrder().getPrice() * notification.getOrder().getQuantity();
                gain += notification.getOrder().getPrice() * notification.getOrder().getQuantity();
            }
            System.out.println("Zlecenie zrealizowane: " + client.getNameOfTheClient()+", kwota do zapłaty = "  + gainNow);

            client.setClientsQueue(clientsQueue);

        }




    }

    public double getGain() {
        return gain;
    }
}