
//Verilen bir dizideki elemanın varlığını ikili arama algoritması kullanarak bulma:
public class BinarySearch {
	public static int Search(int aranan,int[]dizi) {
		int lo=0;
		int hi=dizi.length-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			//System.out.println("Orta :"+mid);
			if(aranan<dizi[mid]) 
				hi=mid-1;
			else if(aranan>dizi[mid])
				lo=mid+1;
			else return mid;
		}
		return -1;
	}
  //Uygulama Sınıfı
public static void main(String[] args) {
//Sıralı olarak 100 elemanlı bir dizi oluşturuyorum. 
		int [] dizi=new int[100];
		for(int i=0;i<100;i++) {
			dizi[i]=i;
		}
    //Static Search methodunu kullanarak 49 sayısının dizide olup olmadığını varsa hangi sırada olduğunu yoksa -1 döndüren fonksiyonu çağırıyorum.
		System.out.println(Search(49,dizi));
