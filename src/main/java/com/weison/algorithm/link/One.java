package com.weison.algorithm.link;

public class One {
    public static void main(String[] args) {
        WeiLink link = new WeiLink();
        link.add(5);
        link.add(3);
        link.add(1);
        link.add(2);
        link.add(55);
        link.add(36);
        System.out.println("linkLength:" + link.length());
        System.out.println("head.data:" + link.head.data);
        link.printLink();
        //link.delete(4);
        System.out.println("After deleteNode(4):");
        link.printLink();
        System.out.println("+++++++++++++++++++++++++++++");
        boolean loop = link.isLoop(link.head);
        System.out.println("have loop:" + loop);
        WeiLink.Node elem = link.findElem(link.head, 2);
        System.out.println("2 node1:" + elem.data);
        WeiLink.Node elem1 = link.getElem(link.head, 2);
        System.out.println("2 node2:" + elem1.data);
        WeiLink.Node node = link.orderList();
        link.printLink();
        link.addNode(link.getElem(link.head, 2));
        //link.printLink();
        boolean loop1 = link.isLoop(link.head);
        System.out.println("have loop1:" + loop1);
        boolean loop2 = link.isLinkedCycle(link.head);
        System.out.println("have loop2:" + loop2);
    }
}
