package com.moviebooking.config;

import com.moviebooking.entity.Movie;
import com.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only add test data if the database is empty
        if (movieRepository.count() == 0) {
            Movie movie1 = new Movie();
            movie1.setTitle("Inception");
            movie1.setDescription("A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.");
            movie1.setGenre("Science Fiction");
            movie1.setLanguage("English");
            movie1.setDuration(148);
            movie1.setRating("PG-13");
            movie1.setReleaseDate(LocalDateTime.now());
            movie1.setActive(true);
            movie1.setPosterUrl("https://i.ibb.co/9LRyCvk/Inception.webp");
            movie1.setTicketPrice(12.99);

            Movie movie2 = new Movie();
            movie2.setTitle("The Dark Knight");
            movie2.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
            movie2.setGenre("Action");
            movie2.setLanguage("English");
            movie2.setDuration(152);
            movie2.setRating("PG-13");
            movie2.setReleaseDate(LocalDateTime.now().minusDays(30));
            movie2.setActive(true);
            movie2.setPosterUrl("https://i.ibb.co/mrWdxfDZ/The-dark-knight.webp");
            movie2.setTicketPrice(12.99);

            Movie movie3 = new Movie();
            movie3.setTitle("파묘 (Exhuma)");
            movie3.setDescription("After suffering from serial paranormal events, a wealthy family brings in a team of shamans and geomancers, only to encounter a powerful force.");
            movie3.setGenre("Horror");
            movie3.setLanguage("Korean");
            movie3.setDuration(133);
            movie3.setRating("R");
            movie3.setReleaseDate(LocalDateTime.now().minusDays(15));
            movie3.setActive(true);
            movie3.setPosterUrl("https://www.themoviedb.org/t/p/w500/xPYL13XPdyysGPmD4lIQCkdXwrV.jpg");
            movie3.setTicketPrice(13.99);

            Movie movie4 = new Movie();
            movie4.setTitle("3 Idiots");
            movie4.setDescription("Two friends are searching for their long lost companion. They revisit their college days and recall the memories of their friend who inspired them to think differently, even as the rest of the world called them idiots.");
            movie4.setGenre("Comedy");
            movie4.setLanguage("Hindi");
            movie4.setDuration(170);
            movie4.setRating("PG");
            movie4.setReleaseDate(LocalDateTime.now().minusDays(45));
            movie4.setActive(true);
            movie4.setPosterUrl("https://www.themoviedb.org/t/p/w500/66A9MqXOyVFCssoloscw79z8Tew.jpg");
            movie4.setTicketPrice(11.99);

            Movie movie5 = new Movie();
            movie5.setTitle("Oppenheimer");
            movie5.setDescription("The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb.");
            movie5.setGenre("Drama");
            movie5.setLanguage("English");
            movie5.setDuration(180);
            movie5.setRating("R");
            movie5.setReleaseDate(LocalDateTime.now().minusDays(7));
            movie5.setActive(true);
            movie5.setPosterUrl("https://www.themoviedb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg");
            movie5.setTicketPrice(14.99);

            // Save all movies
            movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3, movie4, movie5));
            
            System.out.println("Test data initialized successfully!");
        }

        // Ensure a couple of additional movies exist (add if missing)
        if (movieRepository.findByTitleContainingIgnoreCase("Fight Club").isEmpty()) {
            Movie fightClub = new Movie();
            fightClub.setTitle("Fight Club");
            fightClub.setDescription("An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into something much, much more.");
            fightClub.setGenre("Drama");
            fightClub.setLanguage("English");
            fightClub.setDuration(139);
            fightClub.setRating("R");
            fightClub.setReleaseDate(LocalDateTime.of(1999, 10, 15, 0, 0));
            fightClub.setActive(true);
            fightClub.setPosterUrl("https://www.themoviedb.org/t/p/w500/a26cQPRhJPX6GbWfQbvZdrrp9j9.jpg");
            fightClub.setTicketPrice(10.99);
            movieRepository.save(fightClub);
            System.out.println("Added Fight Club to the database");
        }

        if (movieRepository.findByTitleContainingIgnoreCase("Once Upon a Time in Hollywood").isEmpty()) {
            Movie once = new Movie();
            once.setTitle("Once Upon a Time in Hollywood");
            once.setDescription("A faded television actor and his stunt double strive to achieve fame and success in the final years of Hollywood's Golden Age in 1969 Los Angeles.");
            once.setGenre("Drama");
            once.setLanguage("English");
            once.setDuration(161);
            once.setRating("R");
            once.setReleaseDate(LocalDateTime.of(2019, 7, 26, 0, 0));
            once.setActive(true);
            once.setPosterUrl("https://www.themoviedb.org/t/p/w500/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg");
            once.setTicketPrice(13.99);
            movieRepository.save(once);
            System.out.println("Added Once Upon a Time in Hollywood to the database");
        }
    }
}