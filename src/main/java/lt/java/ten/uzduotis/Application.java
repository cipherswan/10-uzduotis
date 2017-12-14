package lt.java.ten.uzduotis;

import lt.java.ten.uzduotis.Repositories.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private ArtistRepository artistRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		Artist pinkFloyd = new Artist("Pink Floyd");
		Set pfalbums = new HashSet<Album>() {{
			add(new Album("Dark Side of the Moon", pinkFloyd));
			add(new Album("Wish You Were Here", pinkFloyd));
			add(new Album("Animals", pinkFloyd));
		}};
		pinkFloyd.setAlbums(pfalbums);

		Artist swans = new Artist("Swans");
		Set swansAlbums = new HashSet<Album>() {{
			add(new Album("The Seer", swans));
			add(new Album("To Be Kind", swans));
			add(new Album("The Glowing Man", swans));
		}};
		swans.setAlbums(swansAlbums);

		artistRepository.save(new HashSet<Artist>() {{
			add(pinkFloyd);
			add(swans);
		}});

		// fetch all categories
		for (Artist bookCategory : artistRepository.findAll()) {
			logger.info(bookCategory.toString());
		}
	}
	*/


}
