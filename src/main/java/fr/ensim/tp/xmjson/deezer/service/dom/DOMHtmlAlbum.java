package fr.ensim.tp.xmjson.deezer.service.dom;

import fr.ensim.tp.xmjson.deezer.data.Album;
import fr.ensim.tp.xmjson.deezer.service.IHtmlAlbum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class DOMHtmlAlbum implements IHtmlAlbum {
  private static Logger log = LogManager.getLogger();

  @Override
  public void write(Album album, OutputStream outputStream) throws Exception {
    log.debug(">>write");

    //TODO
    XMLStreamWriter xmlWriter = XMLOutputFactory
    	      .newInstance()
    	      .createXMLStreamWriter(outputStream);;
      

      

      
      
    	xmlWriter.writeDTD("<!DOCTYPE html>");
    	xmlWriter.writeStartElement("html");
    	xmlWriter.writeAttribute("lang", "en");
    	xmlWriter.writeStartElement("head");
    	xmlWriter.writeDTD("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    	xmlWriter.writeStartElement("title");
    	xmlWriter.writeCharacters("" +album.getTitle());
    	
    	
    	xmlWriter.writeEndElement();
    	xmlWriter.writeEndElement();
    	
    	xmlWriter.writeStartElement("img");
    	xmlWriter.writeAttribute("src",album.getCover());
    	xmlWriter.writeEndElement();

    	xmlWriter.writeStartElement("body");

    	xmlWriter.writeStartElement("p");
    	xmlWriter.writeCharacters("Nom de l'artiste"+album.getArtist().getName());
    	xmlWriter.writeEndElement();

    	
    	for (int i = 0 ; i < album.getTracks().size(); i ++) {
    		
        	xmlWriter.writeStartElement("p");
        	xmlWriter.writeCharacters(album.getTracks().get(i).getTitle());
        	xmlWriter.writeEndElement();
        	
        	xmlWriter.writeStartElement("audio controls");
        	xmlWriter.writeStartElement("source");
        	xmlWriter.writeAttribute("src", album.getTracks().get(i).getPreview());
        	xmlWriter.writeAttribute("type", "audio/mpeg");
        	xmlWriter.writeEndElement();    
        	xmlWriter.writeEndElement();    		

    		
    	}

    	
    	
    	
    	xmlWriter.writeEndElement();
    	xmlWriter.writeEndDocument();
    	xmlWriter.flush();

    
    log.debug("<<write");
  }
}
