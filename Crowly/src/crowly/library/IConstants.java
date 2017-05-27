package crowly.library;


public interface IConstants {
	public final int TIMESCALE = 600;
	
	public final String POST_BODY = "{ \"url\":\"@@URL@@\" }";
	
	public final String MCS_URL = "https://westus.api.cognitive.microsoft.com/video/v1.0/detectmotion?sensitivityLevel=low&mergeTimeThreshold=1.8";
	
	public final String[] LISTA_VIDEOS = {
			"http://gdurl.com/Kh-x" //3PM #1
			//"https://1drv.ms/v/s!AumflabFBeKkcBwfi9eXNgbr7ZE", //3PM #2
			//"https://www.dropbox.com/s/vgnl8dhxee14c5x/3PM_3.MOV?dl=0"  //3PM #3
	};
	
	public final String JSON_FILENAME = "video@@VIDEONUMBER@@.json";
	
	public final String LOCATION_RESULT_URL_KEY = "Operation-Location";
	public final String LOCATION_RESULT_ACCESS_KEY = "apim-request-id";
	public final String CAMBIO_LINEA = "\n";
	
	public final int ESPERA_ENTRE_LLAMADAS = 61000;
	
	public final String MCS_IDKEY = "56c86d0af0a54c45b3bc0c6b7e0c1007";
	
	public final String BAR_CHART = 
 "<html>"
  +"<head>"
    +"<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>"
    +"<script type=\"text/javascript\">"
      +"google.charts.load('current', {'packages':['bar']});"
      +"google.charts.setOnLoadCallback(drawChart);"

      +"function drawChart() {"
        +"var data = google.visualization.arrayToDataTable(["
          +"['Hora', 'Personas'],"
          +"['9 AM', 1000, 400, 200],"
          +"['12 MD', 1170, 460, 250],"
          +"['3 PM', 660, 1120, 300]"
        +"]);"

        +"var options = {"
          +"chart: {"
            +"title: 'Company Performance',"
            +"subtitle: 'Sales, Expenses, and Profit: 2014-2017',"
          +"},"
          +"bars: 'horizontal' // Required for Material Bar Charts."
        +"};"

        +"var chart = new google.charts.Bar(document.getElementById('barchart_material'));"

        +"chart.draw(data, google.charts.Bar.convertOptions(options));"
      +"}"
    +"</script>"
  +"</head>"
  +"<body>"
    +"<div id=\"barchart_material\" style=\"width: 900px; height: 500px;\"></div>"
  +"</body>"
+"</html>";
}
