package algorithm;

public class URLRouting {

	public static void main(String[] args) {
		String requestURI = "https://localhost:9000/webproject/request.jsp";
		String contextPath = "https://localhost:9000/webproject";
		
		String command = requestURI.substring(contextPath.length());
		
		System.out.println(command);

	}

}
