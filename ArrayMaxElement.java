package hello_test;

public class diziEnBuyuk {

	public static void main(String[] args) {
		int [] sayilar=new int[10];
		for (int i=0;i<10;i++) {
			sayilar[i]=i;
		}
		int enBuyuk=sayilar[0];
		for(int i=0;i<sayilar.length;i++) {
			if(enBuyuk<sayilar[i])
				enBuyuk=sayilar[i];
		}
		System.out.println(enBuyuk);

	}

}
