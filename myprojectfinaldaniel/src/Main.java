import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MusicStore {
    private List<Album> albums;

    public MusicStore() {
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
        System.out.println("Album added successfully: " + album.getTitle());
    }

    public void listAlbums() {
        if (albums.isEmpty()) {
            System.out.println("No albums available in the store.");
        } else {
            System.out.println("Available Albums:");
            for (int i = 0; i < albums.size(); i++) {
                System.out.println((i + 1) + ". " + albums.get(i));
            }
        }
    }

    public void searchAlbum(String title) {
        boolean found = false;
        for (Album album : albums) {
            if (album.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Album found: " + album);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Album not found.");
        }
    }
}

class Album {
    private String title;
    private String artist;
    private double price;

    public Album(String title, String artist, double price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Price: $" + price;
    }
}

public class Main {
    public static void main(String[] args) {
        MusicStore store = new MusicStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMusic Store Menu:");
            System.out.println("1. Add Album");
            System.out.println("2. List Albums");
            System.out.println("3. Search Album");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter album title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter album price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Album album = new Album(title, artist, price);
                    store.addAlbum(album);
                    break;

                case 2:
                    store.listAlbums();
                    break;

                case 3:
                    System.out.print("Enter album title to search: ");
                    String searchTitle = scanner.nextLine();
                    store.searchAlbum(searchTitle);
                    break;

                case 4:
                    System.out.println("Exiting Music Store. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
