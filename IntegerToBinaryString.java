public class IntegerToBinaryString {

	public static void main(String[] args) {
    //N isimli tam sayı değerini ikilik tabana çevirip b String'ine atayacağız.
    //Bu işlemde N sürekli 2'ye bölünecek ve kalan sürekli b'ye eklenecek
		int N=50;
		String b="";
		for(int i=N;i>0;i/=2) {
			b=(i%2)+b;
			System.out.println(b);
			
		}
		System.out.println("sonuc: "+b);
	}

}
