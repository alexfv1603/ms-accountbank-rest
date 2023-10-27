package account.bank.model;

public class Client {
	
	private String id;
	private String typeClient;
	private String typeDocument;
	private String numberDocument;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
	public String getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}


}
