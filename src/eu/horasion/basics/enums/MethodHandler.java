package eu.horasion.basics.enums;

public class MethodHandler {

	public String connectionName;
	private HttpMethod httpMethod;

	public MethodHandler(HttpMethod httpMethod, String connectionName) {
		this.httpMethod = httpMethod;
		this.connectionName = connectionName;
	}

	public String getHttpMethodName() {
		return httpMethod.toString();
	}

	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	public boolean isCommonMethod() {
		// Just to demonstrate switch here
		switch(httpMethod) {
			case GET, POST:
				return true;
			default:
				return false;
		}
	}

}
