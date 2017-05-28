package crowly;

import crowly.connectors.MSClient;
import crowly.library.IConstants;
import crowly.library.VideoResponse;

public class VideoProcesor implements IConstants
{
	private MSClient MsClient;
	
	public VideoProcesor()
	{
		MsClient = new MSClient();
	}
	
	public void analizarVideos()
	{
		try 
		{
			int index = 0;
			
			for(String urlVideo : LISTA_VIDEOS) {
				MsClient.procesarVideo(urlVideo, index);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
				index++;
			}
			
			Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			
			for(VideoResponse video : MsClient.getVideosPendientes()) {
				MsClient.procesarRespuestaVideo(video);
				Thread.sleep(ESPERA_ENTRE_LLAMADAS);
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
