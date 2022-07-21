package eu.horasion.basics.enums;

public class EnumsDemo {

	public static void main(String[] args) {
		httpDemo();
		System.out.println("---------");
		imageDemo();
	}

	static void httpDemo() {
		MethodHandler myConnection = new MethodHandler(HttpMethod.CONNECT, "CONNECT test");
		MethodHandler myConnection2 = new MethodHandler(HttpMethod.GET, "GET test");

		System.out.println("Listing all available HTTP methods:");

		for(HttpMethod h : HttpMethod.values()) {
			System.out.print(h.name() + " ");
		}

		System.out.printf("\n\nHTTP method: %s\n", myConnection.getHttpMethodName());
		System.out.printf("Is it a common HTML method? %b\n", myConnection.isCommonMethod());
		System.out.printf("HTTP method: %s\n", myConnection2.getHttpMethodName());
		System.out.printf("Is it a common HTML method? %b\n", myConnection2.isCommonMethod());
	}

	static void imageDemo() {
		ImageFormat myPicture = ImageFormat.PNG;

		System.out.println("Listing all available image formats:");

		for(ImageFormat f : ImageFormat.values()) {
			System.out.printf("%s (%s)\n", f.name(), f.toString());
		}

		System.out.println("Listing details of myPicture which is a PNG...");
		System.out.println("Position in enum declaration: " + myPicture.ordinal());
		System.out.println(myPicture.name());
		System.out.println(myPicture.getImageFormatName());
		System.out.println(myPicture.toString());
	}

}

/*

Listing all available HTTP methods:
GET POST HEAD PUT DELETE CONNECT OPTIONS TRACE PATCH 

HTTP method: CONNECT
Is it a common HTML method? false
HTTP method: GET
Is it a common HTML method? true
---------
Listing all available image formats:
PNG (Format name: Portable Network Graphics)
WEBP (Format name: Web Picture)
JPEG (Format name: Joint Photographic Experts Group)
Listing details of myPicture which is a PNG...
Position in enum declaration: 0
PNG
Portable Network Graphics
Format name: Portable Network Graphics

*/
