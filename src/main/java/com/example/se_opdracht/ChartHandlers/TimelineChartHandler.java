package com.example.se_opdracht.ChartHandlers;

import com.example.se_opdracht.DBHandlers.ProductDBHandler;
import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import javafx.collections.ObservableList;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;

import java.sql.SQLException;

public class TimelineChartHandler extends ChartHandler{
    ProductDBHandler db = new TimelineDBHandler();

    @Override
    protected Chart makeChart() {
        return null;
    }

    @Override
    protected ObservableList loadData() throws SQLException, ClassNotFoundException {
        PieChart chart = new PieChart();
//        chart.setData(getData());
        return null;
    }

//    private ObservableList<PieChart.Data> getData(){
//        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
//        List data = db.getTransactionsAsArrayList();
//        return list;
//    }
}
