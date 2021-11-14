package fr.ensim.tp.xmjson.deezer.service.sax;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import fr.ensim.tp.xmjson.deezer.data.Album;

class SAXSearchAlbumsHandlerTest{
	
	

	
	
	@Test
	void testReadAlbum() throws ParserConfigurationException, SAXException, IOException {
		
		SAXSearchAlbums search = new SAXSearchAlbums();
		InputStream in = getClass().getResourceAsStream("/data/list-album-shakaponk.xml");
		

		List<Album> list = search.readAlbums(in);
		
		assertEquals(25, list.size());
		assertEquals("http://api.deezer.com/2.0/album/81993782/image", list.get(0).getCover());
		assertEquals("http://api.deezer.com/2.0/album/1622537/image", list.get(24).getCover());
		
		assertEquals("83325", list.get(0).getArtist().getId());
		assertEquals("Shaka Ponk", list.get(0).getArtist().getName());
		assertEquals("http://www.deezer.com/artist/83325", list.get(0).getArtist().getLink());
		assertEquals("http://api.deezer.com/2.0/artist/83325/image", list.get(0).getArtist().getPicture());
		
		assertEquals("1671660", list.get(24).getArtist().getId());
		assertEquals("Double hits", list.get(24).getArtist().getName());
		assertEquals("http://www.deezer.com/artist/1671660", list.get(24).getArtist().getLink());
		assertEquals("http://api.deezer.com/2.0/artist/1671660/image", list.get(24).getArtist().getPicture());
		
	}

}
