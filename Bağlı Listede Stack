class NodeL {
	int data;
	NodeL next;
}
class NodeLCreate{
	
	NodeL head;
	
	public void push(int data) {
		NodeL node=new NodeL();
		node.data=data;
		node.next=null;
		if(head==null) {
			head=node;
		}
		else {
			NodeL iter=head;
			while(iter.next!=null) {
				iter=iter.next;
			}
			iter.next=node;
		}
	}
	public int pop() {
		NodeL node=new NodeL();
		if(head==null) {
			System.out.println("Liste boş!");
			return -1;
		}
		if(head.next==null) {
			int rvalue=head.data;
			head=null;
			return rvalue;
		}else {
			NodeL iter=head;
			while(iter.next.next!=null) {
				iter=iter.next;
			}
			
			node=iter.next;
			int rvalue=node.data;
			iter.next=null;
			return rvalue;
		}
		
	}
	public void show() {
		NodeL node=head;
		if(node==null) {
			System.out.println("liste boş");
		}else {
			while(node.next!=null) {
				System.out.println(node.data);
				node=node.next;
			}
			System.out.println(node.data);
		}
		
	}
}
public class StackLinkList {
	
	public static void main(String[] args) {
		NodeLCreate node=new NodeLCreate();
		node.push(1);
		node.push(2);
		node.push(3);
		node.push(4);
		node.push(5);
		node.show();
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		System.out.println(node.pop());
		node.show();
		node.push(1);
		node.push(2);
		node.push(3);
		node.push(4);
		node.push(5);
		node.show();
	}
