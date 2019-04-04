package xmlhandle;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import map.MapPoint;
import map.MapGraph;
import map.MapPath;

public class JAXBMarshalling {

	/*
	 * TODO:implement loading in from xml no need to marshall the objects into xml,
	 * due to the fact that no new nodes will be added by the application
	 */

	// TODO: Write a test for this, import some basic path and ensure it works
	// as expected, this will be good for regression testing.
	public static MapGraph loadMapGraph(String loadPath) throws JAXBException {
		File file = new File(loadPath);
		JAXBContext jaxbContext = JAXBContext.newInstance(MapGraph.class, MapPoint.class, MapPath.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (MapGraph) jaxbUnmarshaller.unmarshal(file);
	}

	public static void main(String[] args) {
		try {
			MapGraph gotGraph = loadMapGraph("resources/GoTGraph.xml");
			System.out.println(gotGraph);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}