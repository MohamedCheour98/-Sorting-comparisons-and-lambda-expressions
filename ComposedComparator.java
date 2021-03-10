import java.util.Comparator;


public class ComposedComparator implements Comparator <Song> {
    private Comparator<Song> s1;
    private Comparator<Song> s2;

    ComposedComparator(Comparator<Song> s1, Comparator<Song> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public int compare(Song a, Song b) {

        Comparator<Song> s1 = (x, y) -> {
            if (x.getArtist().compareTo(y.getArtist()) > 0)
                return 1;
            else if (x.getArtist().compareTo(y.getArtist()) < 0)
                return -1;
            else
                return 0;
        };

        Comparator<Song> s2 = (x, y) -> {
            if (x.getYear() > y.getYear())
                return -1;
            else if (x.getYear() < y.getYear())
                return 1;
            return 0;
        };

        int h = s1.compare(a,b);

        if (h > 0)
            return 1;

        else if (h < 0)
            return -1;

        else return s2.compare(a, b);

    }
}