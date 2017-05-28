package crowly;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import crowly.library.IConstants;

public class JSONDataProcessor implements IConstants {

	private JSONDataProcessor() {
	}

	public static int[] analyzeData() {
		int videoQuantity = LISTA_VIDEOS.length;
		int[] chartData = { 0, 0, 0 };

		JSONParser parser = new JSONParser();

		for (int index = 0; index < videoQuantity; index++) {

			String fileName = JSON_FILENAME.replace("@@VIDEONUMBER@@", index + "");

			Object obj = null;
			try {
				obj = parser.parse(new FileReader(fileName));
				JSONObject data = (JSONObject) obj;

				String processingResultStr = (String) data.get("processingResult");

				System.out.println(processingResultStr);

				Object rObj = parser.parse(processingResultStr);

				JSONObject processingResult = (JSONObject) rObj;

				JSONArray fragments = (JSONArray) processingResult.get("fragments");

				int duracionCuerpo = 0;
				int cuerpos = 0;

				for (Object fragmentObj : fragments) {
					JSONObject fragment = (JSONObject) fragmentObj;
					JSONArray events = (JSONArray) fragment.get("events");

					if (events == null) {
						if(duracionCuerpo > 550){
							if(duracionCuerpo > 2000)
								cuerpos = 3;
							else if(duracionCuerpo > 1200)
								cuerpos = 2;
							else cuerpos = 1;
						}
						
						if (index < 3) {
							chartData[0]+= cuerpos;
						} else if (index >= 3 && index < 6) {
							chartData[1]+= cuerpos;
						} else
							chartData[2]+= cuerpos;
						
						duracionCuerpo = 0;
						cuerpos = 0;
					} else {
						duracionCuerpo += (Long) fragment.get("duration");
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return chartData;

	}

}
