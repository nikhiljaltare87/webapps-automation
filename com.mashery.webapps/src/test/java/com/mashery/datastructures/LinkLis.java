package com.mashery.datastructures;

public class LinkLis {

	Node head;
	private int size;

	LinkLis() {
		size = 0;
	}

	public class Node {
		int data;
		Node next;

		public Node(int data) {

			size++;
			this.data = data;
			this.next = null;

		}

	}

	public void addFirst(int d) {

		Node n = new Node(d);

		if (head == null) {
			head = n;
			printList();
			return;
		}
		n.next = head;
		head = n;
		printList();

	}

	public void addLast(int d) {

		Node n = new Node(d);

		if (head == null) {
			head = n;
			printList();
			return;
		}

		Node currentNode = head;

		while (currentNode.next != null) {

			currentNode = currentNode.next;
		}

		currentNode.next = n;
		printList();

	}

	public void deleteFirst() {

		if (head == null) {
			System.out.println("Link List is Empty");
			return;
		}

		size--;

		if (head.next == null) {
			head = null;
			printList();
			return;
		}
		head = head.next;

		printList();
	}

	public void deleteLast() {

		if (head == null) {
			System.out.println("Link List is Empty");
			return;
		}

		size--;
		if (head.next == null) {
			head = null;
			printList();
			return;
		}

		Node secLastNode = head;
		Node lastNode = head.next;

		while (lastNode.next != null) {
			secLastNode = secLastNode.next;
			lastNode = lastNode.next;
		}
		secLastNode.next = null;
		printList();
	}

	public void deleteEven() {

		if (head == null) {
			System.out.println("Link List is Empty");
			return;
		}
		if (head.next == null) {
			System.out.println("Link List has only one node");
			return;
		}

		printList();

		Node currentNode = head;

		while (currentNode != null) {
			size--;
			currentNode.next = currentNode.next.next;
			currentNode = currentNode.next;
		}

		printList();

	}

	public void deleteAtIndex(int index) {

		Node currentNode = head;

		if (currentNode == null) {
			System.out.println("Link List is Empty");
			return;
		}
		
		while (currentNode != null) {
			System.out.print(currentNode.data + "-->");
			currentNode = currentNode.next;
		}

	}

	public void printList() {

		Node currentNode = head;

		if (currentNode == null) {
			System.out.println("Link List is Empty");
			return;
		}

		while (currentNode != null) {
			System.out.print(currentNode.data + "-->");
			currentNode = currentNode.next;
		}
		System.out.print("null\n");
		System.out.println("Size :" + getSize());
	}

	public int getSize() {
		return size;
	}

	public static void main(String args[]) {

		LinkLis list = new LinkLis();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addLast(0);
		list.addLast(-1);
		list.deleteFirst();
		list.deleteLast();
		list.deleteEven();

	}

}
