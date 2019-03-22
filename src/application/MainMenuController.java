
package application;

import javafx.scene.control.Button;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

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

public class MainMenuController {
	private static File file;
	private static BufferedImage bufferedMapImage;
	public static Image mapImage;
	public static double imageHeight;
	public static double imageWidth;
	@FXML
	MenuBar menuBar;
	@FXML
	Menu helpMenu, fileMenu;
	@FXML
	MenuItem refreshMenuItem, exitMenuItem, aboutMenuItem;
	@FXML
	ImageView backgroundImageView;
	@FXML
	ImageView mapImageView;
	@FXML
	Button findRoutesButton;
	@FXML
	ChoiceBox<String> originChoiceBox, destinationChoiceBox, waypointChoiceBox, avoidChoiceBox; // rawType to be
																								// determined
	@FXML
	AnchorPane mapImageAnchorPane;

	@FXML
	public void initialize() {
		System.out.println("init");
		URL url = getClass().getResource("GoTMap.png");
		file = new File(url.getPath());
		try {
			bufferedMapImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Sets imageView and AnchorPane size to the resolution of the image, that way
		// regardless of what map is loaded in it will work
		mapImage = SwingFXUtils.toFXImage(bufferedMapImage, null);
		imageHeight = mapImage.getHeight();
		imageWidth = mapImage.getWidth();
		mapImageView.setFitHeight(imageHeight);
		mapImageView.setFitWidth(imageWidth);
		mapImageAnchorPane.setMinSize(imageHeight, imageWidth);
		mapImageView.setImage(mapImage);

	}

	@FXML
	public void exit(ActionEvent e) {
		Platform.exit();
	}

}
