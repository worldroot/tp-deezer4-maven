package fr.ensim.tp.xmjson.deezer.service.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.ensim.tp.xmjson.deezer.data.Album;
import fr.ensim.tp.xmjson.deezer.data.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Apparicio
 * 
 */
class SAXSearchAlbumsHandler extends DefaultHandler {
  private static final Logger log = LogManager.getLogger();

  private List<Album>   listAlbum = new ArrayList<Album>();
  
  private boolean isCover;
  private boolean isArtist;
  private boolean isId;
  private boolean isTitle;
  private boolean isAlbum;
  private boolean isNameArtist;
  private boolean isLinkArtist;
  private boolean isPictureArtist;
  


  public SAXSearchAlbumsHandler(List<Album> listAlbum) {
	super();
	this.listAlbum = listAlbum;
}
  
  

public SAXSearchAlbumsHandler() {
	super();
	// TODO Auto-generated constructor stub
}



/**
   * Restitue la liste des albums.
   * 
   * @return
   */
  public List<Album> getListAlbum() {
    return listAlbum;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
   * java.lang.String, java.lang.String, org.xml.sax.Attributes)
   */
  @Override
  public void startElement(String uri,
                           String localName,
                           String qName,
                           Attributes attributes) throws SAXException {

    if (log.isDebugEnabled()) {
      StringBuilder st = new StringBuilder();
      st.append('<');
      st.append(localName);
      
	  Album al = new Album();
	  Artist ar = new Artist();


      

      
      if (localName.equals("id")) {
    	  isId= true;
    	  System.out.println("On est dans ID");
    	  
      }
      if (localName.equals("artist")) {
    	  isArtist= true;
    	  System.out.println("On est dans artist");
    	  if (listAlbum.size() != 0) {
    		  
    		  listAlbum.get(listAlbum.size() - 1).setArtist(ar);

    	  }
    	  else {
    		  listAlbum.get(listAlbum.size()).setArtist(ar);

    	  }
    	  
      }
      if (localName.equals("name")) {
    	  isNameArtist = true;
    	  System.out.println("On est dans name Artist");
    	  
      }
      if (localName.equals("link")) {
    	  isLinkArtist = true;
    	  System.out.println("On est dans link Artist");
    	  
      }
      if (localName.equals("picture")) {
    	  isPictureArtist = true;
    	  System.out.println("On est dans picture Artist");
    	  
      }
      if (localName.equals("title")) {
    	  isTitle= true;
    	  System.out.println("On est dans title");
    	  
      }
      
      if (localName.equals("cover")) {
    	  isCover= true;

    	  System.out.println("On est dans cover");
      }
      
      if (localName.equals("album")) {
    	  isAlbum = true;
    	  listAlbum.add(al);

      }

      
      // Attributs
      for (int i = 0; i < attributes.getLength(); i++) {
        st.append(' ');
        st.append(attributes.getLocalName(i));
        st.append('=');
        st.append(attributes.getValue(i));
      }
      st.append('>');
      log.debug(st);
    }


  }

  /*
   * (non-Javadoc) BufferedReader
   * 
   * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
   * java.lang.String, java.lang.String)
   */
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (log.isDebugEnabled()) {
      StringBuilder st = new StringBuilder();
      st.append("</");
      st.append(localName);
      st.append('>');
      log.debug(st);
    }
    if (localName.equals("cover")) {
  	  isCover= false;
  	  
  	  System.out.println("On est sortie de  cover");
    }
    if (localName.equals("id")) {
    	  isId= false;
    	  
    	  System.out.println("On est sortie de  id");
      }
    if (localName.equals("title")) {
    	  isTitle= false;
    	  
    	  System.out.println("On est sortie de  title");
      }
    if (localName.equals("artist")) {
    	  isArtist= false;
    	  
    	  System.out.println("On est sortie de  artist");
      }
    
    if (localName.equals("album")) {
  	  isAlbum= false;
  	  
  	  System.out.println("On est sortie de  album");
    }
    
    if (localName.equals("name")) {
  	  isNameArtist= false;
  	  
  	  System.out.println("On est sortie de  name artist");
    }
    
    if (localName.equals("link")) {
  	  isLinkArtist= false;
  	  
  	  System.out.println("On est sortie de link artist");
    }
    
    if (localName.equals("picture")) {
    	  isPictureArtist= false;
    	  
    	  System.out.println("On est sortie de  picture artist");
      }
    
    

  }
  
  


  /*
   * (non-Javadoc)
   * 
   * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
   */
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
	  String s = new String(ch, start, length);
	  if (s.isBlank()) return;
	  if (isCover) {
		  if (listAlbum.size() != 0) {
			  
			  listAlbum.get(listAlbum.size() -1).setCover(s);

		  }
		  else {
			  listAlbum.get(listAlbum.size()).setCover(s);

		  }
	  }
	  if (isId) {
		  if (listAlbum.size() != 0) {
			  
			  listAlbum.get(listAlbum.size() -1).setId(s);

		  }
		  else {
			  listAlbum.get(listAlbum.size()).setId(s);

		  }
	  }
	  if (isTitle) {
		  if (listAlbum.size() != 0) {
			  
			  listAlbum.get(listAlbum.size() -1).setTitle(s);

		  }
		  else {
			  listAlbum.get(listAlbum.size()).setTitle(s);

		  }
	  }
	  if (isArtist) {
    	  if (isId) {
    		  
    		  if (listAlbum.size() != 0) {
    			  
    			  
    			  listAlbum.get(listAlbum.size() -1).getArtist().setId(s);

    		  }
    		  else {
    			  listAlbum.get(listAlbum.size()).getArtist().setId(s);	  
    		  	}

    	  }
    	  
    	  if (isNameArtist) {
    		  
    		  if (listAlbum.size() != 0) {
    			  
    			  
    			  listAlbum.get(listAlbum.size() -1).getArtist().setName(s);

    		  }
    		  else {
    			  listAlbum.get(listAlbum.size()).getArtist().setName(s);	  
    		  	}

    	  }
    	  
    	  if (isLinkArtist) {
    		  
    		  if (listAlbum.size() != 0) {
    			  
    			  
    			  listAlbum.get(listAlbum.size() -1).getArtist().setLink(s);

    		  }
    		  else {
    			  listAlbum.get(listAlbum.size()).getArtist().setLink(s);	  
    		  	}

    	  }
    	  
    	  if (isPictureArtist) {
    		  
    		  if (listAlbum.size() != 0) {
    			  
    			  
    			  listAlbum.get(listAlbum.size() -1).getArtist().setPicture(s);

    		  }
    		  else {
    			  listAlbum.get(listAlbum.size()).getArtist().setPicture(s);	  
    		  	}

    	  }
    	  
    	  
    	  
	  }

  }
  
}
