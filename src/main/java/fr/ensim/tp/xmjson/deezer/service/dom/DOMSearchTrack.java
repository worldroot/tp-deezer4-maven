package fr.ensim.tp.xmjson.deezer.service.dom;

import fr.ensim.tp.xmjson.deezer.data.Album;
import fr.ensim.tp.xmjson.deezer.data.Track;
import fr.ensim.tp.xmjson.deezer.service.AbstractSearchTrack;
import fr.ensim.tp.xmjson.deezer.service.Output;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DOMSearchTrack extends AbstractSearchTrack {
  private static Logger log = LogManager.getLogger();

  @Override
  public Output format() {
    return Output.XML;
  }

  @Override
  public List<Track> readTracks(InputStream in) throws Exception {
	List<Track> tracks = new ArrayList<Track>();
    log.debug(">>readTracks");

    // recuperation d'un parser DOM
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    dbFactory.setNamespaceAware(true);
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(in);
    doc.normalize();

    //variables
    Boolean isAlbum= false;
    Boolean isArtist= false;
    // parsing
    DocumentTraversal traversal = (DocumentTraversal) doc;
    NodeIterator iterator = traversal.createNodeIterator(
        doc.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);
    for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
      System.out.println("Element: " + ((Element) n).getTagName());
      
     // if (((Element)n).getTagName().equals("id") && ((Element)n).getParentNode()){
   // 	  isAlbum= true;
    	  
    	  
    	  
     // }
    }

    NodeList nl = doc.getElementsByTagName("track");
    
    for (int i=0; i < nl.getLength() ; i ++) {
    	Track t = new Track();
    	Element enl = (Element)nl.item(i);
    	String title = enl.getElementsByTagName("title").item(0).getFirstChild().getNodeValue();
    	String preview = enl.getElementsByTagName("preview").item(0).getFirstChild().getNodeValue();
    	t.setTitle(title);
    	t.setPreview(preview);
    	tracks.add(t);
    	System.out.println(title);
    	
    }
    
    

    //TODO
    

    log.debug("<<readTracks");
    return tracks;
  }
}
