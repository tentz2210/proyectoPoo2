package crowly.connectors;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import crowly.library.*;

public class MSClient implements IConstants
{
	private ArrayList<VideoResponse> VideosPendientes;

	public ArrayList<VideoResponse> getVideosPendientes() {
		return VideosPendientes;
	}
	
	public MSClient()
	{
		VideosPendientes = new ArrayList<VideoResponse>();
	}
	
	public void procesarVideo(String pURLVideo, int id)
	{
		String payload = POST_BODY.replace("@@URL@@", pURLVideo);
		VideoResponse videoResp = HttpRequestor.post(MCS_URL, payload, MCS_IDKEY, id);
		if (videoResp!=null)
		{
			VideosPendientes.add(videoResp);
		}
	}
	
	public void procesarRespuestaVideo(VideoResponse videoResponse)
	{
		HttpRequestor.get(videoResponse, MCS_IDKEY);
		String videoJSON = videoResponse.getContent();
		try (FileWriter file = new FileWriter("video" + videoResponse.getId() + ".json")) {

			file.write(videoJSON);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
