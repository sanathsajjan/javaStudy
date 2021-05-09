import java.util.Date;

public class CharacterCount {
	public static void main(String[] args) {
//		System.out.println("Hi");
//		String dateC = new Date().toString(); 
//		System.out.println(dateC);
		String input = "parties.$0_party.locations.$0_location";
		String[] arr = input.split("\\.");
		for (int i = 0; i < arr.length; i++) {
			//System.out.println(arr[i]);
			if(arr.length > i+1 && arr[i+1].contains("$")) {
				System.out.println(arr[i+1].substring(arr[i+1].indexOf("_")+1, arr[i+1].length()));
			}
		}
	}
}
