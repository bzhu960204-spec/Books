package CRSPredictor.utils;

import CRSPredictor.CRSPredictorMain;
import CRSPredictor.pojo.CRSHistoryDraw;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class LineChart_AWT extends ApplicationFrame {
    public LineChart_AWT(String applicationTitle, String chartTitle, String xTitle, String yTitle, DefaultCategoryDataset dataset) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                xTitle, yTitle,
                dataset,
//                createTotalCandidateNumberSet(CRSPredictorMain.EEPoolHistoryDraws),
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        LineChart_AWT chart = new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Above 481 Trend",
                "Number of Candidates",
                "Round of Invitation",
                CRSPredictorMain.addTotalCandidateNumberDataSet(new DefaultCategoryDataset(), CRSPredictorMain.EEPoolHistoryDraws)
        );
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
