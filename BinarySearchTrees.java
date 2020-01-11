//Node class
class Node{
	int data;
	Node sag;
	Node sol;
	
}
//Ağacımızın fonksiyonlarının yer aldığı Binary class
class Binary{
	Node root;
	public Binary() {
		root=null;
	}
	
	//root üzerinden ekleme yapacağımız için Binary class'ı içerisinde oluşturduğumuz root'u
	//kullanıyoruz.
	void ekle(int data) {
		root=ekle(root,data);
	}
	//buradaki ekle fonksiyonumuz Node tipinde bir parametre alıyor ve Node tipinde geriye değer döndürüyor.
	public Node ekle(Node n,int data) {
		if (n==null) {
			Node agac=new Node();
			agac.data=data;
			agac.sol=null;
			agac.sag=null;
			n=agac;
			return n;
		}
		//recursive olarak çalışıyor.
		if(n.data<data)
			n.sag=ekle(n.sag,data);
		else if(n.data>data)
			n.sol=ekle(n.sol,data);
		return n;
	}
	void dolas() {
		dolas(root);
	}
	//Küçükten büyüğe sıralıyor.
	public void dolas(Node n) {
		if (n==null)
			return;
		dolas(n.sol);
		System.out.println(n.data);
		dolas(n.sag);
	}
	//Aranan bir değerin varlığını kontrol eden bul fonksiyonu
	int bul(int aranan) {
		return bul(root,aranan);
	}
	int bul(Node n,int aranan) {
		if (n==null)
			return -1;
		if(n.data==aranan)
			return 1;
		if(bul(n.sol,aranan)==1)
			return 1;
		if(bul(n.sag,aranan)==1)
			return 1;
		return -1;
	}
	//Maximum değer:
	int max() {
		return max(root);
	}
	int max(Node n) {
		while(n.sag!=null)
			n=n.sag;
		return n.data;
	}
	//Minumum kodu
	int min() {
		return min(root);
	}
	int min(Node n) {
		while(n.sol!=null)
			n=n.sol;
		return n.data;
	}
	//Silme kodu
	void sil(int aranan) {
		root=sil(root,aranan);
	}
	public Node sil(Node n,int aranan) {
		if(n==null)
			return null;
		//aradığım değer root'un değerine eşitse yani bulmuşsam bu işlemi yap:
		if(n.data==aranan) {
			if(n.sol==null &&n.sag==null)
				return null;
			if(n.sag!=null) {
				n.data=min(n.sag);
				n.sag=sil(n.sag,min(n.sag));
				return n;
			}
			n.data=max(n.sol);
			n.sol=sil(n.sol,max(n.sol));
			return n;
		}
		//aradığım değer root'un değerinden büyükse sağa gidiyor ve recursive olarak sağ'da arıyor değeri,
		if(n.data<aranan) {
			n.sag=sil(n.sag,aranan);
			return n;
		}//Bulamazsa sola gidiyor.
		n.sol=sil(n.sol,aranan);
		return n;
	}
	
}
//Runner test class
public class binary_trees {

	public static void main(String[] args) {
		Binary agac=new Binary();
		
		agac.ekle(5);
		agac.ekle(10);
		agac.ekle(6);
		agac.ekle(100);
		agac.ekle(110);
		agac.ekle(50);
		agac.ekle(1);
		agac.ekle(3);
		agac.ekle(7);
		agac.ekle(1000);
		agac.ekle(80);
		agac.ekle(62);
		//aynı elemanı eklemiyor.
		agac.ekle(7);
		agac.dolas();
		if(agac.bul(100)==1) {
			System.out.println("aranan değer bulundu.");
		}
		System.out.println("maximum değer: "+agac.max());
		System.out.println("minumum değer: "+agac.min());
		System.out.println("62 silindi: ");
		agac.sil(62);
		agac.dolas();
		System.out.println("5 silindi: ");
		agac.sil(5);
		agac.dolas();
	
	}

}
