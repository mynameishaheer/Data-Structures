
public class HanoiRec {
	
	static int count;

	public static void tower(int n, char from, char to, char aux){
		count++;
		
		if (n ==1) {
			System.out.println("Move from: " + from + " to " + to);
			return;
		}
		else {
		tower(n-1, from, aux, to);
		System.out.println("Move from: " + from + " to " + to);
		tower(n-1, aux, to, from);
		}
	}
	
	public static void main (String[] args) {
		tower(6,'A', 'C','B');
		System.out.println("Total recursive calls made: " + (count-1));
	}
	
}
