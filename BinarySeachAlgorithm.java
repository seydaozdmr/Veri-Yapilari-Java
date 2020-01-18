public class binarysearch_rmvdup {
	
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

	}

}
