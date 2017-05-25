package crowly.library;

public class VideoResponse {
	private String VideoResponseURL;
	private String VideoKey;
	private String Content;
	private boolean Procesado;
	
	private int id;
	
	public VideoResponse(String pURL, String pKey, String pContent, int pId)
	{
		VideoResponseURL = pURL;
		VideoKey = pKey;
		Content = pContent;
		Procesado = false;
		id = pId;
	}

	public String getVideoResponseURL() {
		return VideoResponseURL;
	}

	public void setVideoResponseURL(String videoResponseURL) {
		VideoResponseURL = videoResponseURL;
	}

	public String getVideoKey() {
		return VideoKey;
	}

	public void setVideoKey(String videoKey) {
		VideoKey = videoKey;
	}

	public boolean isProcesado() {
		return Procesado;
	}

	public void setProcesado(boolean procesado) {
		Procesado = procesado;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
