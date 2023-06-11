package com.example.se_opdracht.ChartHandlers.Transaction;

import com.example.se_opdracht.ChartHandlers.ChartHandler;
import com.example.se_opdracht.DBHandlers.TransactionChartDBHandler;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionChartHandler extends ChartHandler {



    private TransactionChartDBHandler db = new TransactionChartDBHandler();

    @Override
    protected Chart makeChart() throws SQLException, ClassNotFoundException {
        PieChart chart = new PieChart();
        chart.setData(loadData());
        chart.setTitle("Expenditure per category");
        chart.setClockwise(false);
        chart.setLegendSide(Side.LEFT);



        return chart;
    }

    @Override
    protected ObservableList loadData() throws SQLException, ClassNotFoundException {
        ArrayList<CategoryValue> categoryList = db.getCategoryValue();
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();
        for (CategoryValue value : categoryList){
            chartData.add(new PieChart.Data(value.getName(),value.getValue()));
        }

        return chartData;
    }
}
