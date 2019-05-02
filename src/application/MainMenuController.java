
package application;

import javafx.scene.control.Button;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.xml.bind.JAXBException;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import map.MapGraph;
import map.MapPath;
import map.MapPoint;
import xmlhandle.JAXBMarshalling;

/*
 * @author Hubert stefanski
 *this class is responsible for running the scene and calling all relevant methods/classes to execute appropriate actions
 */

public class MainMenuController {
	private static File mapFile;
	private static BufferedImage bufferedMapImage;
	public static Image mapImage;
	public static double imageHeight;
	public static double imageWidth;
	public static ImageView mapImageViewStatic;
	public static MapPoint source;
	public static MapPoint target;
	public static MapPoint avoid;
	public static MapPoint waypoint;
	public String typeOfRoute;
	public final String loadPath = "resources/GoTGraph.xml";

	@FXML
	MenuBar menuBar;
	@FXML
	Menu settingsMenu, systemMenu;
	@FXML
	MenuItem refreshMenuItem, exitMenuItem, aboutMenuItem, stopMusicMenuItem, overlayGraphMenuItem;
	@FXML
	ImageView backgroundImageView;
	@FXML
	ImageView mapImageView;
	@FXML
	Button findRoutesButton;
	@FXML
	ChoiceBox<String> originChoiceBox, destinationChoiceBox, waypointChoiceBox, avoidChoiceBox;
	@FXML
	ChoiceBox<String> typeOfRouteChoiceBox;
	@FXML
	AnchorPane mapImageAnchorPane;

	@FXML
	public void initialize() throws JAXBException {

		mapImageViewStatic = mapImageView;

		System.out.println("init");
		URL mapUrl = getClass().getResource("GoTMap.png");
		mapFile = new File(mapUrl.getPath());
		try {
			bufferedMapImage = ImageIO.read(mapFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Sets imageView and AnchorPane size to the resolution of the image, that way
		// regardless of what map is loaded in it will work
		mapImage = SwingFXUtils.toFXImage(bufferedMapImage, null);

		imageWidth = mapImage.getWidth();
		imageHeight = mapImage.getHeight();
		mapImageView.setFitWidth(imageWidth);
		mapImageView.setFitHeight(imageHeight);
		mapImageAnchorPane.setMinSize(imageWidth, imageHeight);
		mapImageView.setImage(mapImage);

		MapGraph mapGraph = JAXBMarshalling.loadMapGraph(loadPath);

		for (MapPoint point : mapGraph.getNodes()) {

			originChoiceBox.getItems().addAll(point.getName());
			destinationChoiceBox.getItems().addAll(point.getName());
			waypointChoiceBox.getItems().addAll(point.getName());
			avoidChoiceBox.getItems().addAll(point.getName());
		}
		typeOfRouteChoiceBox.getItems().addAll("Safest", "Fastest", "Easiest");
		SoundFactory.playSound();

	}

	@FXML
	public void findRoutes(ActionEvent e) throws JAXBException {
		MapGraph mapGraph = JAXBMarshalling.loadMapGraph(loadPath);

		for (MapPoint point : mapGraph.getNodes()) {
			String sourceString = originChoiceBox.getValue();
			while (originChoiceBox.getValue() != null) {
				if (sourceString.equals(point.getName())) {
					source = point;
				}
			}
		}
		for (MapPoint point : mapGraph.getNodes()) {
			String destinationString = destinationChoiceBox.getValue();
			while (destinationChoiceBox.getValue() != null) {
				if (destinationString.equals(point.getName())) {
					target = point;
				}
			}
		}

		for (MapPoint point : mapGraph.getNodes()) {
			String waypointString = waypointChoiceBox.getValue();
			while (waypointChoiceBox.getValue() != null) {
				if (waypointString.equals(point.getName())) {
					waypoint = point;
				}
			}
		}
		for (MapPoint point : mapGraph.getNodes()) {
			String avoidString = avoidChoiceBox.getValue();
			while (avoidChoiceBox.getValue() != null) {
				if (avoidString.equals(point.getName())) {
					avoid = point;
				}
			}
		}

		typeOfRoute = typeOfRouteChoiceBox.getValue();
		shortestPathBetween(source, target);

	}

	public List<MapPoint> shortestPathBetween(MapPoint from, MapPoint to) {

		List<MapPoint> routeCalculated = shortestPathBetween(from, to);

		System.out.println("Source : \n" + from + " Target : \n" + to);

		return routeCalculated;

	}

	public void avoidThisNode(ActionEvent e) throws JAXBException {
		MapGraph mapGraph = JAXBMarshalling.loadMapGraph(loadPath);

		for (MapPoint point : mapGraph.getNodes()) {
			for (MapPath path : point.getEdges()) {
				if (!(avoidChoiceBox.getValue() == null)) {
					path.setWeight(Double.MAX_VALUE);
					path.setSafety(Double.MAX_VALUE);
					path.setDistance(Double.MAX_VALUE);
				}
			}
		}
	}

	public void waypointThisNode(ActionEvent e) throws JAXBException {
		MapGraph mapGraph = JAXBMarshalling.loadMapGraph(loadPath);
		for (MapPoint point : mapGraph.getNodes()) {
			for (MapPath path : point.getEdges()) {

				if (!(waypointChoiceBox.getValue() == null)) {
					path.setWeight(Double.MIN_VALUE);
					path.setSafety(Double.MIN_VALUE);
					path.setDistance(Double.MIN_VALUE);
				}
			}
		}
	}

	@FXML
	public void stopMusic(ActionEvent e) {
		SoundFactory.stopSound();

	}

	@FXML
	public void refreshApp(ActionEvent e) {
		mapImageView.setImage(mapImage);
	}

	@FXML
	public void overlayGraph(ActionEvent e) {
		BufferedImage bufferedMapImageToOverlay = SwingFXUtils.fromFXImage(mapImage, null);
		GraphOverlayFactory.drawGraphOverImage(bufferedMapImageToOverlay);
		Image overLayedImage = SwingFXUtils.toFXImage(bufferedMapImageToOverlay, null);
		mapImageView.setImage(overLayedImage);

	}

	@FXML
	public void showAboutMenu(ActionEvent e) {
		System.out.println("Showing authorship");
		JLabel label = new JLabel(
				"<html><center>This Project has been created for <br> Data And Algorithms 2 Continous Assessment by: <br> Hubert Stefanski, Niall Jordan and Oliver Baverstock");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		JOptionPane.showMessageDialog(null, label, "ABOUT", JOptionPane.ERROR_MESSAGE);
		System.out.println("Authorship shown");
	}

	@FXML
	public void exit(ActionEvent e) {
		System.out.println("--------------------Process has been terminated--------------------");
		Platform.exit();
	}

	public static double getImageHeight() {
		return imageHeight;
	}

	public static void setImageHeight(double imageHeight) {
		MainMenuController.imageHeight = imageHeight;
	}

	public static double getImageWidth() {
		return imageWidth;
	}

	public static void setImageWidth(double imageWidth) {
		MainMenuController.imageWidth = imageWidth;
	}

}
