//Node sınıfımız:
class NodeQueue{
	int data;
	NodeQueue next;
}
//enqueue ve dequeue fonksiyonlarım ve show fonksiyonumuzu barındıran sınıf
class NodeLQueue{
	NodeQueue head;
	void enqueue(int data) {
		//İlk başta yeni bir nesne oluşturuyoruz.
		NodeQueue node=new NodeQueue();
		node.data=data;
		node.next=null;
		if(head==null) {
			head=node;
		}else {
			NodeQueue last=head;
			while(last.next!=null) {
				last=last.next;
			}
			last.next=node;
		}
	}
	int dequeue() {
		if(head==null) {
			System.out.println("Linked list boş.");
			return -1;
		}
		int rvalue=head.data;
		head=head.next;
		return rvalue;
	}
	void show() {
		NodeQueue n=head;
		while (n.next!=null) {
			System.out.println(n.data);
			n=n.next;
		}
		System.out.println(n.data);
	}
}
//Deneme kodlarımız:
public class LinkedListQueue {

	public static void main(String[] args) {
		NodeLQueue kuyruk=new NodeLQueue();
		kuyruk.enqueue(5);
		kuyruk.show();
		for(int i=0;i<20;i++) {
			kuyruk.enqueue(i*i);
		}
		kuyruk.show();
		
		for(int i=0;i<13;i++) {
			System.out.println("silinen "+i+".eleman :"+kuyruk.dequeue());
		}
		System.out.println("**************show**************");
		kuyruk.show();
	}

}
