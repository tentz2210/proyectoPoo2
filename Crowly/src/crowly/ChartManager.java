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
		
		for(short index = 0; index < chartData.length; index++){
			chartHTML = chartHTML.replace("@@"+index+"@@", chartData[index]+"");
		}
		
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
