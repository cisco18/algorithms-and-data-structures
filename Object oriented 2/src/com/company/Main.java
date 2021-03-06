package com.company;


public class Main {

    public static void main(String[] args) {
        Magazine magazine = new Magazine();
        Client client = new Client("Andrzej Bułka");
        Order order = new Order("pączki", 100, 1.5);
        Order order1 = new Order("rogale", 150, 1.4);
        Order order2 = new Order("marmoladki", 200, 0.7);
        Order order3 = new Order("chleb", 500, 2);
        Order order4 = new Order("bułki", 2000, 1);
        Notification notification = new Notification(client, order);
        Notification notification1 = new Notification(client, order1);
        Notification notification2 = new Notification(client, order2);
        Notification notification3 = new Notification(client, order3);
        Notification notification4 = new Notification(client, order4);
        client.getClientsQueue().enqueue(notification);
        client.getClientsQueue().enqueue(notification1);
        client.getClientsQueue().enqueue(notification2);
        client.getClientsQueue().enqueue(notification3);
        client.getClientsQueue().enqueue(notification4);
        ElementM elementM = new ElementM(notification);
        Client clientD = new Client("Robert Makłowicz");
        Order orderD = new Order("śruby", 10000, 0.4);
        Order order1D = new Order("śrubokręty", 150, 15);
        Order order2D = new Order("piły", 20, 40);
        Order order3D = new Order("wiertarki", 10, 100);
        Order order4D = new Order("młotki", 100, 20);
        Notification notificationD = new Notification(clientD, orderD);
        Notification notification1D = new Notification(clientD, order1D);
        Notification notification2D = new Notification(clientD, order2D);
        Notification notification3D = new Notification(clientD, order3D);
        Notification notification4D = new Notification(clientD, order4D);
        clientD.getClientsQueue().enqueue(notificationD);
        clientD.getClientsQueue().enqueue(notification1D);
        clientD.getClientsQueue().enqueue(notification2D);
		clientD.getClientsQueue().enqueue(notification3D);
        clientD.getClientsQueue().enqueue(notification4D);
        ElementM elementMD = new ElementM(notificationD);
        magazine.queue.enqueue(elementM);
		magazine.queue.enqueue(elementMD);
        magazine.process();
		System.out.println();
		Magazine magazineA = new Magazine();
		Client clientA = new Client("Jan Pilarski");
		Order orderA = new Order("karty graficzne", 20, 1500);
		Order order1A = new Order("procesory", 60, 1000);
		Order order2A = new Order("dyski twarde", 10, 300);
		Order order3A = new Order("zasilacze", 50, 100);
		Order order4A = new Order("obudowy", 20, 200);
		Notification notificationA = new Notification(clientA, orderA);
		Notification notification1A = new Notification(clientA, order1A);
		Notification notification2A = new Notification(clientA, order2A);
		Notification notification3A = new Notification(clientA, order3A);
		Notification notification4A = new Notification(clientA, order4A);
		clientA.getClientsQueue().enqueue(notificationA);
		clientA.getClientsQueue().enqueue(notification1A);
		clientA.getClientsQueue().enqueue(notification2A);
		clientA.getClientsQueue().enqueue(notification3A);
		clientA.getClientsQueue().enqueue(notification4A);
		ElementM elementMA = new ElementM(notificationA);
		Client clientDA = new Client("Zbigniew Boniek");
		Order orderDA = new Order("piłki", 500, 100);
		Order order1DA = new Order("buty", 150, 150);
		Order order2DA = new Order("getry", 20, 20);
		Order order3DA = new Order("ochraniacze", 20, 50);
		Order order4DA = new Order("szczęki", 10, 15);
		Notification notificationDA = new Notification(clientDA, orderDA);
		Notification notification1DA = new Notification(clientDA, order1DA);
		Notification notification2DA = new Notification(clientDA, order2DA);
		Notification notification3DA = new Notification(clientDA, order3DA);
		Notification notification4DA = new Notification(clientDA, order4DA);
		clientDA.getClientsQueue().enqueue(notificationDA);
		clientDA.getClientsQueue().enqueue(notification1DA);
		clientDA.getClientsQueue().enqueue(notification2DA);
		clientDA.getClientsQueue().enqueue(notification3DA);
		clientDA.getClientsQueue().enqueue(notification4DA);
		ElementM elementMDA = new ElementM(notificationDA);
		magazineA.queue.enqueue(elementMA);
		magazineA.queue.enqueue(elementMDA);
		magazineA.process();
		System.out.println();
		Magazine magazineB = new Magazine();
		Client clientB = new Client("Stefan Bąk");
		Order orderB = new Order("woda", 100, 5);
		Order order1B = new Order("cola", 100, 5);
		Order order2B = new Order("fanta", 100, 5);
		Order order3B = new Order("sprite", 100, 5);
		Order order4B = new Order("pepsi", 200, 5);
		Notification notificationB = new Notification(clientB, orderB);
		Notification notification1B = new Notification(clientB, order1B);
		Notification notification2B = new Notification(clientB, order2B);
		Notification notification3B = new Notification(clientB, order3B);
		Notification notification4B = new Notification(clientB, order4B);
		clientB.getClientsQueue().enqueue(notificationB);
		clientB.getClientsQueue().enqueue(notification1B);
		clientB.getClientsQueue().enqueue(notification2B);
		clientB.getClientsQueue().enqueue(notification3B);
		clientB.getClientsQueue().enqueue(notification4B);
		ElementM elementMB = new ElementM(notificationB);
		Client clientDB = new Client("Anna Szpilka");
		Order orderDB = new Order("rękawice", 100, 100);
		Order order1DB = new Order("worki", 10, 300);
		Order order2DB = new Order("szczęki", 50, 20);
		Order order3DB = new Order("buty", 102, 150);
		Notification notificationDB = new Notification(clientDB, orderDB);
		Notification notification1DB = new Notification(clientDB, order1DB);
		Notification notification2DB = new Notification(clientDB, order2DB);
		Notification notification3DB = new Notification(clientDB, order3DB);
		clientDB.getClientsQueue().enqueue(notificationDB);
		clientDB.getClientsQueue().enqueue(notification1DB);
		clientDB.getClientsQueue().enqueue(notification2DB);
		clientDB.getClientsQueue().enqueue(notification3DB);
		ElementM elementMDB = new ElementM(notificationDB);
		magazineB.queue.enqueue(elementMB);
		magazineB.queue.enqueue(elementMDB);
		magazineB.process();

		System.out.println();

		Company company = new Company();
		company.addMagazine(magazine);
		company.addMagazine(magazineA);
		company.addMagazine(magazineB);
		company.calculateGain();
		company.print();


    }
}
