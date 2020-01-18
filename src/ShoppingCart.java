import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class ShoppingCart extends Application {
    private BorderPane bp = new BorderPane();
    private GridPane gp1 = new GridPane();
    private GridPane gp2 = new GridPane();
    private FlowPane fp1 = new FlowPane();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private VBox vb3 = new VBox();
    private ObservableList<Items> data;

    public void start(Stage s) {
        TableView<Items> tv1; //store Item objects
        tv1 = new TableView<>();
        Alert alerts = new Alert(Alert.AlertType.ERROR); // error message
        Scene sc1, sc2, sc3, sc4;
        sc1 = new Scene(new Group());
        s.setTitle("Yeslyn and Madison's Project");
        s.sizeToScene(); // setting stage to size according to the scene sizes

        //top pane in the main screen
        //add button
        Button b = new Button("Add");
        b.setStyle("-fx-background-color: #a8d1ff;");
        //Update button
        Button b2 = new Button("Update");
        b2.setStyle("-fx-background-color: #a8d1ff;");
        //remove button
        Button b3 = new Button("Remove");
        b3.setStyle("-fx-background-color: #a8d1ff;");
        //Print Button
        Button b4 = new Button("Begin");
        b4.setStyle("-fx-background-color: #a8d1ff;");

        fp1.setHgap(10);
        fp1.getChildren().addAll(b, b2, b3);





        //Right Pane with a title and tableview
        data = FXCollections.observableArrayList();
        s.setWidth(800);
        s.setHeight(500);
        final Label l1 = new Label("Item Details");
        l1.setFont(new Font("Helvecta", 22));

        //column 1
        TableColumn namecol = new TableColumn("Item Name");
        namecol.setMinWidth(20);
        namecol.setCellValueFactory(new PropertyValueFactory<Items, String>("ItemName"));

        //column 2
        TableColumn codecol = new TableColumn("Item Code");
        codecol.setMinWidth(20);
        codecol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("ItemCode"));

        //Column 3
        TableColumn quantitycol = new TableColumn("Quantity");
        quantitycol.setMinWidth(10);
        quantitycol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("ItemQuantity"));

        //Column 4
        TableColumn discountcol = new TableColumn("Discount");
        discountcol.setMinWidth(20);
        discountcol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("ItemDiscount"));

        //Column 5
        TableColumn pricecol = new TableColumn("Price");
        pricecol.setMinWidth(20);
        pricecol.setCellValueFactory(new PropertyValueFactory<Items, Integer>("ItemPrice"));

        tv1.setEditable(true);
        tv1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tv1.setItems(data); //table items are getting populated from observable list
        tv1.getColumns().addAll(namecol, codecol, quantitycol, discountcol, pricecol);
        vb1.getChildren().addAll(l1, tv1);

        // Left pane w/ a grid pane and an add button
        Label ln = new Label();
        ln.setText("Name");
        Label l2 = new Label();
        l2.setText("Code");
        Label l3 = new Label();
        l3.setText("Quantity");
        Label l4 = new Label();
        l4.setText("Discount");
        Label l5 = new Label();
        l5.setText("Price");

        TextField tn = new TextField();
        TextField tc = new TextField();
        TextField tq = new TextField();
        TextField tp = new TextField();
        TextField td = new TextField();
        Button b1 = new Button("Add");
        b1.setStyle("-fx-background-color: #a8d1ff;");

        gp1.add(ln, 0, 0);
        gp1.add(tn, 1, 0);
        gp1.add(l2, 0, 1);
        gp1.add(tc, 1, 1);
        gp1.add(l3, 0, 2);
        gp1.add(tq, 1, 2);
        gp1.add(l4, 0, 3);
        gp1.add(tp, 1, 3);
        gp1.add(l5, 0, 4);
        gp1.add(td, 1, 4);
        gp1.setPadding(new Insets(10, 10, 10, 10));
        gp1.setHgap(10);
        gp1.setVgap(10);
        vb2.setSpacing(5);
        vb2.setPadding(new Insets(5, 5, 5, 5));
        vb2.getChildren().addAll(gp1, b1);
        vb2.setVisible(false);
        bp.setPadding(new Insets(10, 10, 10, 10));
        bp.setLeft(vb2);
        bp.setRight(vb1);
        bp.setTop(fp1);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb2.setVisible(true); //clicking new button makes left side visible
            }
        };
        b.setOnAction(event1);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { //ADD AN ITEM
            @Override
            public void handle(ActionEvent event) {
                data.add(new Items(tn.getText(),
                        Integer.parseInt(tc.getText()),
                        Integer.parseInt(tq.getText()),
                        Double.parseDouble(tp.getText()),
                        Double.parseDouble(td.getText()),
                        Integer.parseInt(tp.getText())));
                tn.clear();
                tc.clear();
                tq.clear();
                tp.clear();
                td.clear();
                tp.clear();
            }
        };
        b1.setOnAction(event2);

        ((Group) sc1.getRoot()).getChildren().add(bp); //Border pane added to the scene

        s.setScene(sc1);
        s.show();

        //Scene 2 (Updating a listed item)
        Label lb2 = new Label("Enter the code of the item you want to update");
        lb2.setFont(new Font("Helvecta", 14));
        Label lbc = new Label("Code");
        Label lbn = new Label("New Name");
        Label lbq = new Label("New Quantity");
        Label lbd = new Label("New Discount");
        Label lbp = new Label("New Price");
        TextField tfc = new TextField();
        TextField tfn = new TextField();
        TextField tfq = new TextField();
        TextField tfd = new TextField();
        TextField tfp = new TextField();
        Button bu = new Button("Update");
        bu.setStyle("-fx-background-color: #a8d1ff;");
        gp2.add(lbc, 0, 0);
        gp2.add(tfc, 1, 0);
        gp2.add(lbn, 0, 1);
        gp2.add(tfn, 1, 1);
        gp2.add(lbq, 0, 2);
        gp2.add(tfq, 1, 2);
        gp2.add(lbd, 0, 3);
        gp2.add(tfd, 1, 3);
        gp2.add(lbp, 0, 4);
        gp2.add(tfp, 1, 4);
        gp2.setPadding(new Insets(10, 10, 10, 10));
        gp2.setHgap(10);
        gp2.setVgap(10);
        vb3.getChildren().addAll(lb2, gp2, bu);
        vb3.setSpacing(10);

        EventHandler<ActionEvent> event22 = new EventHandler<ActionEvent>() { //UPDATE ITEM
            @Override
            public void handle(ActionEvent actionEvent) {
                double stn = Double.parseDouble(tfc.getText());
                boolean f = false;
                for (int i = 0; i < tv1.getItems().size(); i++) {
                    if (tv1.getItems().get(i).getItemCode() == stn){
                        Items ni = new Items(tfn.getText(),
                                Integer.parseInt(tfc.getText()),
                                Integer.parseInt(tfq.getText()),
                                Double.parseDouble(tfp.getText()),
                                Double.parseDouble(tfd.getText()),
                                Integer.parseInt(tp.getText()));
                        tv1.getItems().set(i, ni);
                        f = true;
                    }
                }
                if (f) {
                    alerts.setTitle("Successfully Updated");
                    alerts.setHeaderText("YAY");
                    alerts.setContentText("You have successfully updated an item");
                    alerts.showAndWait();
                } else {
                    alerts.setTitle("Error");
                    alerts.setHeaderText("awe");
                    alerts.setContentText("The ID you have entered was not found");
                    alerts.showAndWait();
                }
                tfn.clear();
                tfc.clear();
                tfq.clear();
                tfd.clear();
                tfp.clear();
                s.setScene(sc1);
            }
        };
        bu.setOnAction(event22);

        sc2 = new Scene(vb3, 500, 400);
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent eventUpdate) {
                s.setScene(sc2);
            }
        };
        b2.setOnAction(event3);

        //Scene 3 (The remove button)
        VBox vb4 = new VBox();
        Label lr = new Label("Enter the item code you want to remove");
        TextField tfr = new TextField();
        Button br = new Button("Delete");
        br.setStyle("-fx-background-color: #a8d1ff;");
        vb4.getChildren().addAll(lr, tfr, br);
        vb4.setPadding(new Insets(10, 10, 10, 10));
        vb4.setSpacing(10);
        sc3 = new Scene(vb4, 400, 500);

        EventHandler<ActionEvent> event33 = new EventHandler<ActionEvent>() { //REMOVE AN ITEM
            public void handle(ActionEvent event) {
                int stn = Integer.parseInt(tfr.getText());
                boolean f = false;
                for (int i = 0; i < tv1.getItems().size(); i++) {
                    double one = tv1.getItems().get(i).getItemCode();
                    if (one == stn) {
                        tv1.getItems().remove(i);
                        f = true;
                    }
                }
                if (f) {
                    alerts.setTitle("Sucessfully Updated");
                    alerts.setHeaderText("YAY");
                    alerts.setContentText("You have sucessfully delete an item");
                    alerts.showAndWait();
                } else {
                    alerts.setTitle("Error");
                    alerts.setHeaderText("awe");
                    alerts.setContentText("The ID you have entered was not found");
                    alerts.showAndWait();
                }
                tfn.clear();
                tfc.clear();
                tfq.clear();
                tfd.clear();
                tfp.clear();
                s.setScene(sc1);
            }
        };
        br.setOnAction(event33);

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                s.setScene(sc3);
            }
        };
        b3.setOnAction(event4);

        //Scene 4 (Print button)
        double subTotal = 0, tax = 0, total = 0;
        final double TAX_RATE = 0.0825;
        VBox vb5 = new VBox();
        Label lp = new Label("Printed Receipt");
        lp.setFont(new Font("Helvecta", 16));
        Button b5 = new Button("Return");
        b5.setStyle("-fx-background-color: #a8d1ff; ");
        Label lpr = new Label("Total");
        lpr.setFont(new Font("Helvecta", 20));
        Label lps = new Label("Discount Total: ");
        lps.setFont(new Font("Helvetica", 15));
        Label lpt = new Label("Tax: 8.25% ");
        lpt.setFont(new Font("Helvetica", 15));
        Label lpg = new Label("Grand Total: ");
        lpg.setFont(new Font("Helvetica", 15));
        TableView tv2 = new TableView();
        tv2.setEditable(true);
        tv2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tv2.setItems(data); //table items are getting populated from observable list
        tv2.getColumns().addAll(namecol, codecol, quantitycol, discountcol, pricecol);
        tv2.setMaxHeight(200);

        vb5.getChildren().addAll(lp, b5, tv2, lpr, lps, lpt, lpg);
        vb5.setPadding(new Insets(10, 10, 10, 10));
        vb5.setSpacing(10);
        sc4 = new Scene(vb5, 400, 500);

        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                s.setScene(sc4);
                double totalPrice = 0;
                double priceAndItem = 0;
                for (int i = 0; i< tv1.getItems().size(); i++ ) {

                    double ip = tv1.getItems().get(i).getItemPrice();
                    double numberOFItems = tv1.getItems().get(i).getItemQuantity();
                    String itemName = tv1.getItems().get(i).getItemName();
                    double customerDiscount = tv1.getItems().get(i).getItemDiscount();
                    double kitchen, disc1 = 0;
                    double bedding, disc2 = 0;
                    double bathroom, disc3 = 0;

                    switch (itemName){
                        case "bedding":
                            bedding = (numberOFItems * ip);
                            disc2 = (bedding - (bedding * .25));
                            break;
                        case "kitchen":
                            kitchen = (numberOFItems * ip);
                            disc1 = (kitchen - (kitchen * .25));
                            break;
                        case "bathroom":
                            bathroom = (numberOFItems * ip);
                            disc3 = (bathroom - (bathroom * .25));
                            break;
                        default:
                            customerDiscount = 0;
                            break;
                    }
                    priceAndItem = priceAndItem + numberOFItems * ip;
                    totalPrice = priceAndItem + disc1 + disc2 + disc3 - customerDiscount;
                }
                lpr.setText(" Sub Total: " + (totalPrice));
                if (totalPrice >= 1000){
                    totalPrice = (totalPrice - (totalPrice * 0.25));
                }
                else {
                    totalPrice = priceAndItem;
                }
                double totalDiscount = priceAndItem - totalPrice;
                lps.setText("Discount: " + totalDiscount);
                double tax = 0;

                tax = (totalPrice + (totalPrice * TAX_RATE));
                lpg.setText("Final Total: " + tax);
            }
        };
        b4.setOnAction(event5);

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                s.setScene(sc1);
            }
        };
        b5.setOnAction(event6);
    }
}