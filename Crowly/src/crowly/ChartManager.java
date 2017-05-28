package crowly;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import crowly.library.IConstants;

public class ChartManager implements IConstants{

	private static ChartManager instance;
	
	private ChartManager(){}
	
	public static ChartManager getInstance(){
		if(instance == null){
			instance = new ChartManager();
			return instance;
		}
		return instance;		
	}
	
	public void generateChart(short option, int[] chartData){
		String chartHTML = CHARTS[option];
		
		chartHTML = chartHTML.replace("@@9AM@@", chartData[0]+"");
		chartHTML = chartHTML.replace("@@12MD@@", chartData[1]+"");
		chartHTML = chartHTML.replace("@@3PM@@", chartData[2]+"");
		
		try (FileWriter file = new FileWriter("CrowlyGUID.html")) {

			file.write(chartHTML);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void openChart(){
		File crowlyHtml = new File(DIRECTORY.replace('\\', '/')+"/CrowlyGUID.html");
		try {
			Desktop.getDesktop().browse(crowlyHtml.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
