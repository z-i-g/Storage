package dataStructures.LinkedList;

import java.util.ArrayList;

public class LinkedList {

	public Node head;
	public Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	// проверка пустой ли список
	public boolean isEmpty() {
		if (this.head == null)
			return true;
		return false;
	}

	// добавление узла в конец списка
	public void addInTail(Node item) {
		if (isEmpty()) {
			this.head = item;
			this.tail = item;
		} else {
			this.tail.next = item;
			item.prev = tail;
			item.next = null;
			this.tail = item;
		}
	}

	// поиск необходимого узла
	public Node find(int value) {
		Node node = this.head; // от первого узла списка
		while (node != null) {
			if (node.value == value)
				return node;
			node = node.next;
		}
		return null;
	}

	// поиск всех узлов с необходимым значением
	public ArrayList<Node> findAll(int _value) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node node = find(_value);
		Node temp = node;
		while (node != null) {
			if (node.value == temp.value) {
				nodes.add(node);
			}
			node = node.next;
		}
		return nodes;
	}

	// удаление необходимого узла
	public boolean remove(int _value) {
		Node node = find(_value); // узел с найденным значением
		if (node != null) {

			if ((node == this.head) & (node == this.tail)) { // если узел единственный в списке
				this.head = null;
				this.tail = null;
				System.out.println("odin");
				return true;
			}

			if (node == this.head) { // если удаляемый узел первый в списке
				this.head = node.next;
				node.prev = null;
				System.out.println("first");
			} else {
				if (node == this.tail) {
					this.tail = node.prev;
					node.prev.next = null;// если удаляемый узел последний в списке
					System.out.println("last");
				} else {
					node.next.prev = node.prev;
					node.prev.next = node.next;
				}
			}
			System.out.println("ok");
			return true;
		}
		return false; // если узел не был найден и удален
	}

	// удаление всех узлов с необходимым значением
	public void removeAll(int _value) {
		Node node = find(_value);
		Node temp = node;
		while (node != null) { // до конца списка
			if (node.value == temp.value) {
				remove(node.value);
			}
			node = node.next;
		}
	}

	// очиститка списка
	public void clear() {
		this.head = null;
		this.tail = null;
	}

	// подсчет и вывод всех узлов списка
	public int count() {
		int i = 0;
		Node node = this.head;
		while (node != null) {
			i++;
			System.out.println(node.value);
			node = node.next;
		}
		return i;
	}

	// вставка нового узла после указанного
	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {

		if (isEmpty()) { // если список пуст
			this.head = _nodeToInsert;
			this.tail = _nodeToInsert;
		} else {

			if (find(_nodeAfter.value) == null) { // если _nodeAfter = null, то узел вставляется в начало списка
				this.head.prev = _nodeToInsert;
				_nodeToInsert.next = this.head;
				this.head = _nodeToInsert;
			} else {

				if (_nodeAfter.value == find(_nodeAfter.value).value) { // если _nodeAfter не null
					_nodeToInsert.next = _nodeAfter.next;
					_nodeToInsert.prev = _nodeAfter;
					_nodeAfter.next = _nodeToInsert;
					_nodeAfter.next.prev = _nodeToInsert;

					if (_nodeAfter == this.tail) { // если _nodeAfter последний узел в списке
						_nodeAfter.next = _nodeToInsert;
						_nodeToInsert.prev = _nodeAfter;
						this.tail = _nodeToInsert;

					}

				}
			}
		}

	}

}

class Node {

	public int value;
	public Node next;
	public Node prev;

	public Node(int _value) {
		value = _value;
		next = null;
		prev = null;
	}

}