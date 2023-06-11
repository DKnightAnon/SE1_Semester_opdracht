package com.example.se_opdracht.ChartHandlers;

import javafx.collections.ObservableList;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public abstract class ChartHandler  {

    Chart chart;

    public Chart initialize() {
        try {
            chart = makeChart();
            loadData();

            return chart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Chart update() throws SQLException, ClassNotFoundException {
        return makeChart();
    }

    protected abstract Chart makeChart()throws SQLException, ClassNotFoundException;

    protected abstract ObservableList loadData() throws SQLException, ClassNotFoundException;
}
