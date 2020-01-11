//Queue_ dizi tanımını yaptığımız ve enque ve deque fonksiyonlarını içeren sınıfımız.
class Queue_{
	int capacity=4;
	int[] dizi=new int[capacity];
	int sira=0;
	int sirabasi=0;
	int deque() {
		if(sira==sirabasi) {
			System.out.println("sıra boş");
			return -1;
		}
		System.out.println("boyut1: "+capacity+"sira: "+sira+"sirabasi: "+sirabasi+"fark : "+(sira-sirabasi));
		if(sira-sirabasi<=capacity/4) {
			int[]dizi2=new int[capacity/2];
			for(int i=0;i<(sira-sirabasi);i++) {
				dizi2[i]=dizi[sirabasi+i];
			}
			sira-=sirabasi;
			sirabasi=0;
			dizi=dizi2;
			capacity=capacity/2;
		}
		
		//sira--;
		return dizi[sirabasi++];
	}
	void toparla() {
		if (sirabasi==0)
			return;
		for(int i=0;i<=sira;i++) {
			//System.out.println(dizi[i]);
			dizi[i]=dizi[i+sirabasi];
		}
		sira-=sirabasi;
		sirabasi=0;
	}
	void enque(int data) {
		//Eğer dizinin kapasitesi kadar eleman eklersek, kapasiteyi iki katına çıkarıyoruz.
		if(sira>=capacity) {
			int[]dizi2=new int[capacity*2];
			for(int i=0;i<capacity;i++) {
				dizi2[i]=dizi[i];
			}
			dizi=dizi2;
			capacity*=2;
		}
		dizi[sira++]=data;
	}
	void show() {
		for(int i=sirabasi;i<capacity;i++) {
			System.out.println(dizi[i]);
		}
	}
}


//Test Sınıfımız
public class QueueTest {

	public static void main(String[] args) {
		Queue_ kuyruk=new Queue_();
		//System.out.println(kuyruk.sirabasi);
		//kuyruk.toparla();
		//System.out.println("sira: "+kuyruk.sira);
		//System.out.println("Toplarla:");
		//kuyruk.show();
		System.out.println("*********SHOW*********");
		for(int i=0;i<20;i++) {
			kuyruk.enque(i);
		}
		
		kuyruk.show();
		System.out.println("boyut2: "+kuyruk.capacity+"sira: "+kuyruk.sira+"sirabasi: "+kuyruk.sirabasi+"fark : "+(kuyruk.sira-kuyruk.sirabasi));
		for(int i=0;i<13;i++) {
			kuyruk.deque();
		}
		System.out.println("*********SHOW*********");
		kuyruk.show();
		System.out.println("boyut3: "+kuyruk.capacity+"sira: "+kuyruk.sira+"sirabasi: "+kuyruk.sirabasi+"fark : "+(kuyruk.sira-kuyruk.sirabasi));
	}

}
