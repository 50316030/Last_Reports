package report;

import report.FramesystemView;
import report.DBconnect;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Label;
import java.awt.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main {
	
	static String name;
	static int id,record;
	static ResultSet rs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FramesystemView frame = new FramesystemView();
		DBconnect db = new DBconnect();
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		rs = db.selectAll();
		
		try {
			while(rs.next()){
				id = rs.getInt("id");
			    name = rs.getString("name");
			    record = rs.getInt("record");
			    frame.add(new Label("î‘çÜ " + String.valueOf(id)));
			    frame.add(new Label("ñºëO " + String.valueOf(name)));
			    frame.add(new Label("ê¨ê—" + String.valueOf(record)));
			    data.addValue(record, "record", String.valueOf(name));

			}
			JFreeChart chart = 
					ChartFactory.createBarChart("Student's records",
				                                   "name",
				                                   "record",
				                                   data,
				                                   PlotOrientation.VERTICAL,
				                                   true,
				                                   false,
				                                   false);

				    ChartPanel cpanel = new ChartPanel(chart);
		frame.add(cpanel, BorderLayout.CENTER);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

