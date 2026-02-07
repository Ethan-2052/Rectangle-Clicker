package com.example;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.image.*;


public class App extends Application {
    double currency = 0;
    String dollarOrDollars = " dollars";
    double CPS = 0; //CPS stands for currency per second
    double robobNumber = 0;
    double robobCost = 10;
    double lemonNumber = 0;
    double lemonCost = 100;
    boolean factoryUnlock = false;
    double factoryNumber = 0;
    double factoryCost = 1000;
    boolean businessUnlock = false;
    double businessNumber = 0;
    double businessCost = 10000;
    boolean printingUnlock = false;
    double printingNumber = 0;
    double printingCost = 100000;
    boolean planetUnlock = false;
    double planetNumber = 0;
    double planetCost = 1000000;
    boolean solarSystemUnlock = false;
    double solarSystemNumber = 0;
    double solarSystemCost = 10000000;


  @Override
  public void start(Stage stage) {
      Scene scene = new Scene(new Label("Hello, JavaFX!"), 400, 200);
      stage.setScene(scene);
      stage.setTitle("JavaFX App");
      stage.show();

       //sets the screen with all the buttons and text

       Image dollar = new Image("file:C:\\Users\\Azreal\\Downloads\\download.jpg");
       ImageView dollarPic = new ImageView(dollar);
       dollarPic.setFitWidth(30);
       dollarPic.setFitHeight(30);

      VBox root = new VBox();

        HBox nameOfGame = new HBox();
        Label label1 = new Label("Welcome to rectangle clicker        ");
        TextField nameOfPlayer = new TextField("Alfred");
        Label company = new Label("'s Company");
        nameOfGame.getChildren().addAll(label1, nameOfPlayer, company);

      Label label2 = new Label("You have " + currency + dollarOrDollars);

        HBox buttonAndCPS = new HBox();
        Button button1 = new Button("", dollarPic);
        Label label3 = new Label("                       Dollars per second: " + CPS);
        buttonAndCPS.getChildren().addAll(button1, label3);

      Button upgrade1 = new Button("purchase ro-bob, $" + robobCost);
      Button upgrade2 = new Button("puchase lemonade stand, $" + lemonCost);
      Button upgrade3 = new Button("?");
      Button upgrade4 = new Button("?");
      Button upgrade5 = new Button("?");
      Button upgrade6 = new Button("?");
      Button upgrade7 = new Button("?");

      root.getChildren().addAll(dollarPic, nameOfGame, label2, buttonAndCPS, upgrade1, upgrade2, upgrade3, upgrade4, upgrade5, upgrade6);

      scene.setRoot(root);

      //rectangle pressed

      button1.setOnAction(e -> {
        currency += 10000;
        if(currency == 1){
            dollarOrDollars = " dollar";
        } else {
            dollarOrDollars = " dollars";
        };
        label2.setText("You have " + currency + dollarOrDollars);
      });

      //ro-bob button pressed

      upgrade1.setOnAction(e -> {
        if(currency>=robobCost){
          currency -= robobCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          robobNumber++;
          robobCost = Math.floor(robobCost*1.5);
          upgrade1.setText("robobs now cost $" + robobCost + "        " + toComma(robobCost));   
          CPS += 1;
          label3.setText("                       Dollars per second: " + CPS);
        }
      });

      //lemonade stand button pressed

      upgrade2.setOnAction(e -> {
        if(currency>=lemonCost){
          currency -= lemonCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          lemonNumber++;
          lemonCost = Math.floor(lemonCost*1.5);
          upgrade2.setText("Lemonade stands now cost $" + lemonCost);
          CPS += 10;
          label3.setText("                       Dollars per second: " + CPS);
          if(!factoryUnlock){
            upgrade3.setText("Purchase factory $" + factoryCost);
            factoryUnlock = true;
          }
        }
      });

      //factory button pressed

      upgrade3.setOnAction(e -> {
        if(currency>=factoryCost){
          currency -= factoryCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          factoryNumber++;
          factoryCost = Math.floor(factoryCost*1.5);
          upgrade3.setText("Factories now cost $" + factoryCost);
          CPS += 100;
          label3.setText("                       Dollars per second: " + CPS);
          if(!businessUnlock){
            upgrade4.setText("Purchase large business $" + businessCost);
            businessUnlock = true;
          }
        }
      });

      //business button pressed

      upgrade4.setOnAction(e -> {
        if(currency>=businessCost){
          currency -= businessCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          businessNumber++;
          businessCost = Math.floor(businessCost*1.5);
          upgrade4.setText("Businesses now cost $" + businessCost);
          CPS += 1000;
          label3.setText("                       Dollars per second: " + CPS);
          if(!printingUnlock){
          upgrade5.setText("Purchase printing press $" + printingCost);
          printingUnlock = true;
          }
        }
      });

      //printing press button pressed

      upgrade5.setOnAction(e -> {
        if(currency>=printingCost){
          currency -= printingCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          printingNumber ++;
          printingCost = Math.floor(printingCost*1.5);
          upgrade5.setText("Printing presses now cost $" + printingCost);
          CPS += 10000;
          label3.setText("                       Dollars per second: " + CPS);
          if(!planetUnlock){
            upgrade6.setText("Purchase planet $" + planetCost);
            planetUnlock = true;
          }
        }
      });

      //planet button pressed

      upgrade6.setOnAction(e -> {
        if(currency>=planetCost){
          currency -= planetCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          planetNumber ++;
          planetCost = Math.floor(planetCost*1.5);
          upgrade6.setText("planets now cost $" + planetCost);
          CPS += 100000;
          label3.setText("                       Dollars per second: " + CPS);
          if(!solarSystemUnlock){
            upgrade7.setText("Purchase solar system $" + solarSystemCost);
            solarSystemUnlock = true;
          }
        }
      });

      upgrade7.setOnAction(e -> {
        if(currency>=solarSystemCost){
          currency -= solarSystemCost;
          if(currency == 1){
            dollarOrDollars = " dollar";
          } else {
            dollarOrDollars = " dollars";
          };
          label2.setText("You have " + currency + dollarOrDollars);
          solarSystemNumber ++;
          solarSystemCost = Math.floor(solarSystemCost*1.5);
        }
      });


      //this makes the currency increase by the CPS (Currency Per Second) every second

      Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(1), e -> {
          currency += CPS;
          label2.setText("You have " + currency + dollarOrDollars);
        })
      );

      timeline.setCycleCount(Animation.INDEFINITE);
      timeline.play();
   }

   public static String toComma(double cost) {
    int itemPriceInt = (int) cost; //turns cost into an int (so that there are no decimals)
    String itemPrice = Integer.toString(itemPriceInt); //turns itemPriceInt into a string to we can check the length
    String commaVersion = Integer.toString(itemPriceInt);
    if(itemPrice.length() >= 4 && itemPrice.length() <=6 ){
      if(itemPrice.length() == 4){
        commaVersion = itemPrice.charAt(0) + "," + itemPrice.charAt(1) + itemPrice.charAt(2) + itemPrice.charAt(3);
      }else if(itemPrice.length() == 5) {
        commaVersion = itemPrice.charAt(0) + itemPrice.charAt(1) + "," + itemPrice.charAt(2) + itemPrice.charAt(3) + itemPrice.charAt(4);
      }else if(itemPrice.length() == 6){
        commaVersion = itemPrice.charAt(0) + itemPrice.charAt(1) + itemPrice.charAt(2) + "," + itemPrice.charAt(3) + itemPrice.charAt(4) + itemPrice.charAt(5);
      }
    } else if(itemPrice.length()>=7 && itemPrice.length() < 10){
      if(itemPrice.length() == 7){
        commaVersion = itemPrice.charAt(0) + "." + itemPrice.charAt(1) + itemPrice.charAt(2) + " million";
      }
    }
    return commaVersion;
}
   public static void main(String[] args) {
       launch(args);
   }
}

