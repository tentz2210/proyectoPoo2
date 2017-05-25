package crowly.connectors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import crowly.library.*;

public class MSClient implements IConstants
{
	private ArrayList<Cuerpo> Cuerpos;
	private ArrayList<VideoResponse> VideosPendientes;
	
	public ArrayList<Cuerpo> getCuerpos() {
		return Cuerpos;
	}

	public ArrayList<VideoResponse> getVideosPendientes() {
		return VideosPendientes;
	}
	
	public MSClient()
	{
		Cuerpos = new ArrayList<Cuerpo>();
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
		
	public void cargarCuerpos() {
		int videoQuantity = LISTA_VIDEOS.length;

		JSONParser parser = new JSONParser();

		for (int index = 0; index <= videoQuantity; index++) {

			String fileName = JSON_FILENAME.replace("@@VIDEONUMBER@@", index + "");

			Object obj = null;
			try {
				obj = parser.parse(new FileReader(fileName));
				JSONObject data = (JSONObject) obj;

				JSONArray fragments = (JSONArray) data.get("fragments");

				for (Object fragmentObj : fragments) {
					JSONObject fragment = (JSONObject) fragmentObj;
					JSONArray events = (JSONArray) fragment.get("events");

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			

		}

		// aqui proceso el Json creando los objetos Cuerpo que vienen
		// en el Json y los meto uno a uno en la lista de Cuerpos
	}
}
