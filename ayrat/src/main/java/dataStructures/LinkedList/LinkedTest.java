package dataStructures.LinkedList;

public class LinkedTest {

	public static void main(String[] args) {

		LinkedList linkedL = new LinkedList();
		Node n1 = new Node(3);
		Node n2 = new Node(7);
		Node n3 = new Node(4);
		Node n4 = new Node(7);
		Node n5 = new Node(8);
		Node n6 = new Node(7);
		Node n10 = new Node(22);
			linkedL.addInTail(n1);
			linkedL.addInTail(n2);
			linkedL.addInTail(n3);
			linkedL.addInTail(n4);
//			linkedL.addInTail(n5);
			linkedL.addInTail(n6);

		System.out.println("count " + linkedL.count());
//		linkedL.addInTail(n5);

			linkedL.insertAfter(n6, n10);
			System.out.println("pervi" + linkedL.head.value);
			System.out.println("posledni" + linkedL.tail.prev.value);
			System.out.println("count " + linkedL.count());


			System.out.println("count " + linkedL.count());
			linkedL.removeAll(7);
//			linkedL.removeAll(8);
//			linkedL.addInTail(n3);

//		System.out.println(linkedL.find(4));

//		linkedL.remove(3);

//			ArrayList<Node> nodes2 = linkedL.findAll(3);
		//
//			for (Node n : nodes2) {
//				System.out.println(n.value);
//			}

		System.out.println("count " + linkedL.count());
		linkedL.removeAll(22);
		System.out.println(linkedL.count());
		System.out.println("pervi" + linkedL.head.value);
		System.out.println("posledni" + linkedL.tail.value);
//			linkedL.addInTail(n10);

		//
//			linkedL.removeAll(7);
//			
//			linkedL.clear();
//			System.out.println(linkedL.count());
//			linkedL.remove(6);

	}

}
