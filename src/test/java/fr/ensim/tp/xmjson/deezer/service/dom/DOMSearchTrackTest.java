package fr.ensim.tp.xmjson.deezer.service.dom;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ensim.tp.xmjson.deezer.data.Track;

class DOMSearchTrackTest {

	@Test
	void readTracks() throws Exception {
		InputStream in = getClass().getResourceAsStream("/data/album-81993952.xml");
		DOMSearchTrack  dt = new DOMSearchTrack();
		List<Track> liste_tracks = dt.readTracks(in);
		
		assertEquals("Intro (Live)", liste_tracks.get(0).getTitle());
		assertEquals("http://cdn-preview-8.deezer.com/stream/c-841484a5831c5fd4c8246cc752d72c3a-5.mp3", liste_tracks.get(0).getPreview());
		
		
	}

}
