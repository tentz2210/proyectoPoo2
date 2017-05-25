package crowly.library;


public interface IConstants {
	public final String POST_BODY = "{ \"url\":\"@@URL@@\" }";
	
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low";
	
	public final String[] LISTA_VIDEOS = {
			"http://gdurl.com/9KHx",
			"https://www.dropbox.com/s/nhc9xsxlnsn0bv8/WIN_20170503_15_26_09_Pro.mp4?dl=0"
	};
	
	public final String JSON_FILENAME = "video@@VIDEONUMBER@@.json";
	
	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int ESPERA_ENTRE_LLAMADAS = 61000;
	
	public final String MCS_IDKEY = "56c86d0af0a54c45b3bc0c6b7e0c1007";
}
