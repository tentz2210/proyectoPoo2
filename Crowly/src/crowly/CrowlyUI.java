package crowly;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import crowly.library.IConstants;

public class CrowlyUI implements WindowConstants, IConstants {
	
	private static CrowlyUI instance;
	
	private CrowlyUI(){}

	public static CrowlyUI getInstance(){
		if(instance == null){
			instance = new CrowlyUI();
			return instance;
		}
		return instance;
	}
	
	public void initialize(){
		
		JFrame mainWindow = new JFrame("Crowly");
		mainWindow.setSize(new Dimension(600, 400));
		mainWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mainWindow.setLayout(null);
		mainWindow.setVisible(true);
		
		JButton barChartButton = new JButton(new ImageIcon("images\\bar.png"));
		JLabel barLbl = new JLabel("Bar Chart");
		
		JButton scatterChartButton = new JButton(new ImageIcon("images\\scatter.png"));
		JLabel scatterLbl = new JLabel("Scatter Chart");
		
		JButton lineChartButton = new JButton(new ImageIcon("images\\line.png"));
		JLabel lineLbl = new JLabel("Line Chart");
		
		barChartButton.setBounds(68, 128, 64, 64); barChartButton.setVisible(true);
		scatterChartButton.setBounds(268, 128, 64, 64); scatterChartButton.setVisible(true);
		lineChartButton.setBounds(468, 128, 64, 64); lineChartButton.setVisible(true);
		
		barChartButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        createChart(BAR);
		    } 
		});
		
		scatterChartButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        createChart(SCATTER);
		    } 
		});
		
		lineChartButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        createChart(LINE);
		    } 
		});
		
		barLbl.setBounds(71, 194, 100, 20);
		scatterLbl.setBounds(261, 194, 100, 20);
		lineLbl.setBounds(471, 194, 100, 20);
		
		barChartButton.setVisible(true);
		scatterChartButton.setVisible(true);
		lineChartButton.setVisible(true);
		
		barLbl.setVisible(true);
		scatterChartButton.setVisible(true);
		lineChartButton.setVisible(true);
		
		mainWindow.add(barChartButton);
		mainWindow.add(scatterChartButton);
		mainWindow.add(lineChartButton);
		
		mainWindow.add(barLbl);
		mainWindow.add(scatterLbl);
		mainWindow.add(lineLbl);
		
		mainWindow.repaint();
	}
	
	private void createChart(short option){
		int[] chartData = JSONDataProcessor.analyzeData();
		ChartManager.getInstance().generateChart(option, chartData);
		ChartManager.getInstance().openChart();
	}
}
