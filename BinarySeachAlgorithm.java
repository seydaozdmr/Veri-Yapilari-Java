public class binarysearch_rmvdup {
	//Gönderilen dizide tekrar eden elemanları temizleyip yeni bir dizi olarak gönderen algoritma
	public static int [] removeDuplicates(int[]whitelist) {
		int[] newWhiteList=new int[whitelist.length];
		
		newWhiteList[0]=whitelist[0];
		int count=0;
		
		for(int i=1;i<whitelist.length;i++) {
			if(whitelist[i]!=newWhiteList[count]) {
				count++;
				newWhiteList[count]=whitelist[i];
			}
		}
		count++;
		//yeni liste içerisindeki bilgileri boşlukları yok edecek şekilde compact list'e copyalayacağız.
		int [] compactNewWhiteList=new int[count];
		System.arraycopy(newWhiteList, 0, compactNewWhiteList, 0, count);
		return compactNewWhiteList;
	}
	//Bir dizi içerisinde aranan elemanların yer aldığı diziyi karşılaştıran olmayanları + olanları - olarak belirten algoritma
	public static void binarySearch(int []arr,int[]numbers,char karakter) {
		if(karakter=='+') {
			System.out.println("Beyaz liste içerisinde olmayan elemanlar: ");
		}else {
			System.out.println("Beyaz liste içerisinde olan elemanlar : ");
		}
		
		int countNumbers=0;
		//arana elemanların dizi boyutu kadar dön
		for(int i=0;i<numbers.length;i++) {
			//ara:
			int index=rank(numbers[i],arr,0,arr.length-1);
			if(karakter=='+' && index==-1) {
				//Yazılacak ilk değer sıfıra eşit değilse her defasında sayıyı yazdıktan sonra yanına virgül atıyor
				if(countNumbers!=0) {
					System.out.print(", ");
				}
				System.out.print(numbers[i]);
				countNumbers+=1;
			}else if(karakter=='-' && index!=-1) {
				if(countNumbers!=0) {
					System.out.print(", ");
				}
				System.out.print(numbers[i]);
				countNumbers+=1;
			}
		}
		
	}
	
	//İkili arama algoritması
	public static int rank(int key,int[] arr,int lo,int hi) {
		if(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			
			if(key<arr[mid]) {
				return rank(key,arr,lo,mid-1);
			}else if(key>arr[mid]) {
				return rank(key,arr,mid+1,hi);
			}else {
				return mid;
			}
		}else {
			return -1;
		}
	}
  
  //Test
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int[] numbers = {1, 4 , 5, 9, 10};
		
		Arrays.sort(arr);
		//Olmayanlar:
		binarySearch(arr, numbers, '+');
		System.out.println();
		//Olanlar
		binarySearch(arr, numbers, '-');
		System.out.println();
		int[] whitelist = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8,11,12,13,14};
		int[] keys = {1, 4 , 5, 9, 10,13};
		Arrays.sort(whitelist);
		int[] yenilist=removeDuplicates(whitelist);
		binarySearch(yenilist,keys,'+');
		System.out.println();
		binarySearch(yenilist,keys,'-');

	}

}
