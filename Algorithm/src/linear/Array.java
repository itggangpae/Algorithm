package linear;

public class Array {
	//데이터를 마지막에 삽입하는 메소드
	public static void append(Object [] ar, Object data) {
		Object [] result = new Object[ar.length+1];
		
		int i = 0;
		for(Object obj : ar) {
			result[i] = obj;
			i++;
		}
		result[result.length-1] = data;
		
		ar = result;
	}
	
	//데이터를 중간에 삽입하는 메소드
	public static void insert(Object[] ar, int idx,  Object data) {
		if(idx < 0 || idx > ar.length) {
			System.out.println("데이터를 삽입할 수 없는 위치입니다.");
		}
		Object [] result = new Object[ar.length+1];
		
		int i = 0;
		for(i=0; i<idx; i++) {
			result[i] = ar[i];
		}
		result[idx] = data;
		for(i=idx; i<ar.length; i++) {
			result[i+1] = ar[i];
		}
		ar = result;
	}
	
	//데이터를 삭제하는 메소드
	public static void delete(Object [] ar, int idx) {
		if(idx < 0 || idx > ar.length - 1) {
			System.out.println("데이터를 삭제할 수 없는 위치입니다.");
		}
		Object [] result = new Object[ar.length-1];
		
		int i = 0;
		for(i=0; i<idx; i++) {
			result[i] = ar[i];
		}
		for(i=idx+1; i<ar.length; i++) {
			result[i-1] = ar[i];
		}
		ar = result;
	}
}
