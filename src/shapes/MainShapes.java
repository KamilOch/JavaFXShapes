package javaFxZajeciaDwaShapes;




import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class MainShapes extends Application{

    @Override
    public void start(Stage primaryStage) {
        try {

            Group root = new Group();
            Scene scene = new Scene(root, 400, 400,Color.GRAY);

            //czerwona linia
            Line redLine = new Line(10,10,200,10);
            redLine.setStroke(Color.RED);
            redLine.setStrokeWidth(10);
            redLine.setStrokeLineCap(StrokeLineCap.ROUND);
            root.getChildren().add(redLine);

            //niebieska linia przerywana
            Line blueLine = new Line(10,40,200,40);
            blueLine.setStroke(Color.BLUE);
            blueLine.setStrokeWidth(10);
            blueLine.setStrokeLineCap(StrokeLineCap.BUTT);
            blueLine.getStrokeDashArray().addAll(30d,15d,5d,30d);
            blueLine.setStrokeDashOffset(25);


            root.getChildren().add(blueLine);

            //Suwak zwiazany ze "setStrokeDashOffset"
            Slider slider = new Slider(0d,80d,25d);
            slider.setLayoutX(10);
            slider.setLayoutY(70);
            slider.setOrientation(Orientation.HORIZONTAL);
            //slider.setMinWidth(200d);
            //slider.setMaxWidth(200d);

            //powiazanie slider do setStrokeDashOffset
            blueLine.strokeDashOffsetProperty().bind(slider.valueProperty());

            root.getChildren().add(slider);

            //Cubic Curve
            CubicCurve cubicCurve = new CubicCurve(
                    50,75,
                    80,-25,
                    110,175
                    ,140,75);
            cubicCurve.setTranslateX(220);
            cubicCurve.setTranslateY(-40);
            cubicCurve.setFill(Color.TRANSPARENT);
            cubicCurve.setStroke(Color.BLACK);
            cubicCurve.setStrokeWidth(4);
            root.getChildren().add(cubicCurve);

            //rysowanie po sciezce
            Path path = new Path();
            path.setStrokeWidth(5);
            MoveTo moveTo = new MoveTo(50,150);
            QuadCurveTo quadCurvTo = new QuadCurveTo();
            quadCurvTo.setX(150);
            quadCurvTo.setY(150);
            quadCurvTo.setControlX(100);
            quadCurvTo.setControlY(50);

            LineTo lineTo1 = new LineTo(50,150);
            LineTo lineTo2 = new LineTo(100,275);
            LineTo lineTo3 = new LineTo(150,150);

            path.getElements().addAll(moveTo,quadCurvTo, lineTo1,lineTo2,lineTo3);
            root.getChildren().add(path);

            //odejmowanie 2 obiektow od siebie
            Ellipse bigElipse = new Ellipse(100,100,50,36);
            Ellipse smallElipse = new Ellipse(100,100,17,12);

            Shape donut = Path.subtract(bigElipse,smallElipse);
            donut.setTranslateX(200);
            donut.setFill(Color.rgb(255,200,0));
            donut.setStroke(Color.BLACK);
            donut.setStrokeWidth(2);

            //dodawanie efektu specjalnego :) cien
            DropShadow dropShadow = new DropShadow(1,12.0,12.0,Color.rgb(200,200,200));
            donut.setEffect(dropShadow);

            root.getChildren().add(donut);

            //Wypelnienie gradientowe liniowe
            Rectangle roundRect = new Rectangle(250,250,100,100);
            roundRect.setArcHeight(20);
            roundRect.setArcWidth(20);

            root.getChildren().add(roundRect);

            LinearGradient lrGradient = new LinearGradient(
                    0.25,0.25,
                    0.75,0.75,
                    true,
                    CycleMethod.REFLECT,
                    new Stop(0,Color.RED),
                    new Stop(0.5, Color.YELLOW),
                    new Stop(1,Color.BLUE));

            roundRect.setFill(lrGradient);

 //           scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
