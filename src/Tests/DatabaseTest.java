import com.example.se_opdracht.DBHandlers.DBhandler;
import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineProductCategory;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionProduct;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionProductCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseTest {

    /*
    These methods are not Junit Tests. However, these were what I used during the development process to check

     */

    private static TimelineDBHandler TLDB = new TimelineDBHandler();

//URL for home directory database : jdbc:h2:~/bptDB

    private static String jdcbURL = "jdbc:h2:~/bptDB";
    private static String user = "admin";
    private static String password = "admin";
    public static String connected = "Connected to database!";
    public static String disconnected = "Disconnected from database!";
    public static String connectionUnable = "Unable to connect to database...";

   /* public static Connection connection() throws SQLException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(jdcbURL, user, password);
            System.out.println(connected);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    };*/

    public static void TestAll() throws SQLException, ClassNotFoundException {
       // printDatabaseAllTransactions();
        createTablesInDatabase();
        printDatabaseTransaction();
        printTimelineProducts();
        printTimeLineCategories();
        insertTransactionProduct();
        System.exit(0);
    }

    public static void printDatabaseAllTransactions() throws SQLException {
        ObservableList<TransactionProduct> tpList = FXCollections.observableArrayList();
        ObservableList<TransactionProductCategory> tpcList = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection(jdcbURL, user, password);
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Purchase_ID, Date, Item, Description, Name, category_ID FROM PURCHASE JOIN expense_category ON purchase.Category = expense_category.Category_ID;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tpList.add(new TransactionProduct(
                        rs.getInt("Purchase_ID"),
                        rs.getString("Date"),
                        rs.getString("Item"),
                        rs.getString("Description"),
                        rs.getString("Name")));
                tpcList.add(new TransactionProductCategory(
                        rs.getString("Category_ID"),
                        rs.getInt("NAME")));


            }
            for (int i = 0; i < tpList.size(); i++) {
                System.out.printf("%d, %s, %s, %s, %d, %s, %d",
                        tpList.get(i).getID(),
                        tpList.get(i).getDate(),
                        tpList.get(i).getName(),
                        tpList.get(i).getDescription(),
                        tpList.get(i).getCategory(),
                        tpcList.get(i).getCategoryName(),
                        tpcList.get(i).getCategoryID());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printDatabaseTransaction() {
        try {
            Connection connection = DriverManager.getConnection(jdcbURL, user, password);
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Purchase_ID, Date, Item, Description, Name FROM PURCHASE JOIN expense_category ON purchase.Category = expense_category.Category_ID;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("Purchase_ID");
                String date = rs.getString("Date");
                String item = rs.getString("Item");
                String description = rs.getString("Description");
                String category = rs.getString("Name");//category
                System.out.printf("%d, %s, %s, %s, %s\n", id, date, item, description, category);
            }
            if (!rs.next()) {
                System.out.println("No further results for transactions\n");
            }
            ps = connection.prepareStatement("SELECT * FROM EXPENSE_CATEGORY ");
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                int id = rs2.getInt("Category_ID");
                String name = rs2.getString("NAME");
                System.out.printf("%d, %s\n", id, name);
            }
            if (!rs.next()) {
                System.out.println("No further results for Transaction categories\n");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTimelineProducts() throws SQLException, ClassNotFoundException {
        ObservableList<TimelineProduct> list = TLDB.getProducts();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s,%s,%s,%d\n",
                    list.get(i).getName(),
                    list.get(i).getDescription(),
                    list.get(i).getCategory(),
                    list.get(i).getProductID()
            );
            System.out.println("No further results for Timeline Products\n");
        }
        //System.exit(0);
    }

    public static void printTimeLineCategories() throws SQLException, ClassNotFoundException {
        ObservableList<TimelineProductCategory> list = TLDB.getCategories();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d, %s\n",
                    list.get(i).getCategoryID(),
                    list.get(i).getCategoryName()
            );
            System.out.println("No further results for Timeline Categories\n");
        }
        //System.exit(0);

    }
    public static void insertTransactionProduct(){
        try {
            String insertion = "INSERT INTO PURCHASE (Date, Item, Description, Category) VALUES ('26-03-2022', 'testitem','testdescription',1);";
            PreparedStatement psInsert = null;
            Connection con = DriverManager.getConnection(DBhandler.getJdcbURL(), DBhandler.getUser(), DBhandler.getPassword());
            psInsert = con.prepareStatement(insertion);
            psInsert.executeUpdate();
            System.out.println("Successfully inserted a Transaction Product entry into table Purchase!\n");
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTablesInDatabase() {
        try {
            String createExpenseCategory = "    DROP TABLE IF EXISTS Expense_Category; " +
                    "    CREATE TABLE Expense_Category(" +
                    "    Category_ID int NOT NULL AUTO_INCREMENT," +
                    "    Name varchar(255)," +
                    "    PRIMARY KEY(Category_ID)" +
                    "    );";
            String createTimelineProduct = "    DROP TABLE IF EXISTS TimelineProduct;\n" +
                    "    CREATE TABLE IF NOT EXISTS TimelineProduct(\n" +
                    "    Product_ID int NOT NULL AUTO_INCREMENT,\n" +
                    "    Name varchar(255) NOT NULL,\n" +
                    "    Description varchar(600),\n" +
                    "    Category integer not null,\n" +
                    "    PRIMARY KEY(Product_ID)\n" +
                    "    );";
            String createProductPurchaseDate = "    DROP TABLE IF EXISTS ProductPurchaseDate;\n" +
                    "    CREATE TABLE IF NOT EXISTS ProductPurchaseDate(\n" +
                    "    PurchaseDate_ID int NOT NULL AUTO_INCREMENT,\n" +
                    "    Date varchar(20) NOT NULL,\n" +
                    "    PurchasePrice NUMERIC(20,2),\n" +
                    "    Product_ID integer NOT NULL,\n" +
                    "    PRIMARY KEY(PurchaseDate_ID),\n" +
                    "    FOREIGN KEY (Product_ID) REFERENCES TimelineProduct(Product_ID)\n" +
                    "    );";
            String createTimelineProductCategory = "    DROP TABLE IF EXISTS TimelineProductCategory;\n" +
                    "    CREATE TABLE IF NOT EXISTS TimelineProductCategory(\n" +
                    "    Category_ID int NOT NULL AUTO_INCREMENT,\n" +
                    "    CategoryName varchar(255) NOT NULL,\n" +
                    "    PRIMARY KEY(Category_ID)\n" +
                    "    );";
            String createPurchase = "    DROP TABLE IF EXISTS Purchase;\n" +
                    "    CREATE TABLE Purchase(\n" +
                    "    Purchase_ID int not null auto_increment,\n" +
                    "    Date varchar(20) NOT NULL,\n" +
                    "    Item varchar(600),\n" +
                    "    Description varchar(255),\n" +
                    "    Category integer NOT NULL,\n" +
                    "    PRIMARY KEY (Purchase_ID),\n" +
                    "    FOREIGN KEY (Category) REFERENCES Expense_Category(Category_ID)\n" +
                    "    );";
            ArrayList<String> createTables = new ArrayList<String>();
            createTables.add(createExpenseCategory);
            createTables.add(createTimelineProduct);
            createTables.add(createProductPurchaseDate);
            createTables.add(createTimelineProductCategory);
            createTables.add(createPurchase);
            Connection con = DriverManager.getConnection(jdcbURL, user, password);
            for (int i = 0; i<createTables.size();i++) {
                PreparedStatement psInsert = con.prepareStatement(createTables.get(i));
                psInsert.executeUpdate();
            }
            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //TestAll();
        printDatabaseTransaction();
        //printTimelineProducts();
        //printTimeLineCategories();
        //insertTransactionProduct();
        //printDatabaseAllTransactions();
        //createTablesInDatabase();

    }
}
