//Çift yönlü bağlı listemin sınıfı:
public class DoubleNode {
	int data;
	DoubleNode next;
	DoubleNode prev;
}
//Çift yönlü bağlı listelerimin fonksiyonları:
public class DoubleLinkedList {
	DoubleNode head;
	
	public DoubleNode siraliekle(int data) {
		DoubleNode node=new DoubleNode();
		node.prev=null;
		node.next=null;
		node.data=data;
		if(head==null) {
			head=node;
			return head;
		}
		if(head.data>node.data) {
			node.next=head;
			head.prev=node;
			head=node;
			return head;
		}
		DoubleNode n=head;
		while(n.next!=null && n.next.data<data) {
			n=n.next;
		}//Node temp eleman yani geçici eleman'ın next'ine iter yani n.next'in değeri veriliyor.
		//n.next'in yeni değeri de node oluyor ve node yani geçiçi eleman araya ekleniyor.
		node.next=n.next;
		n.next=node;
		node.prev=n;
		if(node.next!=null) {
			node.next.prev=node;
		}
		return n;	
	}
  
	public DoubleNode sil(int deger) {
		DoubleNode node=new DoubleNode();
		node.data=deger;
		node.next=null;
		node.prev=null;
		DoubleNode n=head;
		if(head.data==node.data) {
			head=n.next;
			System.out.println("ilk elemean değer :"+n.data);
			return n;
		}
		while(n.next!=null && n.next.data!=node.data) {
			n=n.next;
		}
		if(n.next==null) {
			System.out.println("silinecek eleman bulunamadı...");
			return n;
		}		
		node=n.next;
		n.next=node.next;
		if(n.next!=null) {
			node.next.prev=n;
		}
		return n;
	}
  
	public void show() {
		//root değerini gösteriyor ilk başta 
		//ilk iterator Node node oluyor.
		DoubleNode node=head;
		//Liste elemanlarına erişmek için liste elemanları üzerinde hareket ediyoruz.
		while(node.next!=null){
			//linked list üzerinde dolaşan aynı tipte bir iterator yapısı
			System.out.println(node.data);
			//iter next yapılıyor, next kutuyu gösteriyor.
			node=node.next;
		}
		System.out.println(node.data);
	}
  
  //Uygulama Sınıfı
  public class DoubleListRunner {

	public static void main(String[] args) {
		DoubleLinkedList list=new DoubleLinkedList();
		list.siraliekle(10);
		list.siraliekle(1);
		list.siraliekle(500);
		list.siraliekle(50);
		list.show();
		list.sil(55);
		list.sil(1);
		list.sil(500);
		list.sil(50);
		list.show();
	}

}
}
