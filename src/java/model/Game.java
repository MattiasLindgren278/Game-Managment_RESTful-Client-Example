package model;

import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utilities.LocalDateAdapter;

@XmlRootElement
public class Game {

    private int id;
    private String title;
    private String genre;
    private List<Console> consoles;
    private int storageSpace;

    private LocalDate releaseDate;

    public Game(String title, String genre, List<Console> consoles, LocalDate releaseDate, int storageSpace) {
        this.title = title;
        this.genre = genre;
        this.consoles = consoles;
        this.releaseDate = releaseDate;
        this.storageSpace = storageSpace;
    }

    public Game(String title) {
        this.title = title;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Console> getConsoles() {
        return consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }

    public int getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", title=" + title + ", genre=" + genre + ", platform=" + consoles + ", storageSpace=" + storageSpace + ", releaseDate=" + releaseDate + '}';
    }

}
