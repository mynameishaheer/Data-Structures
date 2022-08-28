
class filing<T extends Comparable<T>>{
	T[] arr;
	int currIndex;

	filing() // default constructor to create an array
	{
		arr = (T[])new Comparable[10];
		currIndex=-1;
	}
	filing(int size) // constructor to create an array
	{
		arr = (T[])new Comparable[size];
		currIndex=-1;
	}
	public String toString(){
		String str = "";
		for(int i=0; i<arr.length;i++)
			str=str+arr[i]+ "\n";
		return str;
	}
	public void add (T data) // method to add value in an array
	{ 
		if(currIndex == arr.length-1) {
			T[] arrB = arr;
			T[] arr = (T[]) new Comparable[2*arr.length-1];
			for (int i = 0; i<arr.length; i++) {
				arr[i] = arrB[i];
			}
		}

		if (currIndex == -1) {
			arr[0] = data;
			currIndex++;
		}

		else {
			int i;
			for (i = currIndex; i>=0; i--) {
				if (data.compareTo(arr[i])<0) {
					arr[i+1] = arr[i];
				}
				else {
					break;
				}
			}
			arr[currIndex+1] = data;
			currIndex++;
		}


	}
	public int Find(T value)
	{
		for (int i = 0; i <= currIndex; i++){
			if(value.compareTo(arr[i]) == 0) {
				return i;
			}
		}
	} 

	public T get(int value){ 
		if (value< arr.length-1 )
			return arr[value]; 
	}
	public void update(T value, int index)
	{
		arr[index] = value;
	}

	public void remove(T value){
		boolean found = false;
		int index = 0;
		for (int i = arr.length-1; i > -1; i--) {
			if (value.equals(arr[i])) {
				index = i;
				arr[i]= null;
				found = true;
				break;
			}
		}
		if (found= true) {
			for (int i = index+1; i< arr.length;i++) {
				arr[index] = arr[i];
				index++;
			}

			System.out.println("Value found and removed");
		}
		else {
			System.out.println("Value not found!");
		}
	}
	public static void main (String[] args) {
		
		filing a = new filing(5);
		
		int b = 5;
		
		a.add(b);
		a.add(3);
		a.add(13);
		a.add(15);
		
		
		System.out.println(a.toString());
		
		a.remove(3);
		a.remove(7);
		
		System.out.println(a.toString());
		
		
	}

}