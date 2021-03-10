import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   private static final Song[] songs1 = new Song[] {
           new Song("Gerry Rafferty", "Baker Street", 1978),
           new Song("Gerry Rafferty", "Baker Street", 1998)
   };

   private static final Song[] songs2 = new Song[] {
           new Song("Decemberists", "The Mariner's Revenge Song", 2005),
           new Song("Queen", "Love's Lost Guarantee", 2005),
           new Song("Avett Brothers", "Talk on Indolence", 2006),
           new Song("Gerry Rafferty", "Baker Street", 1998),
           new Song("City and Colour", "Sleeping Sickness", 2007),
           new Song("Foo Fighters", "Baker Street", 1997),
           new Song("Queen", "Bohemian Rhapsody", 1975),
           new Song("Gerry Rafferty", "Baker Street", 1978)
   };

   private static final Song[] songs3 = new Song[] {
           new Song("Decemberists", "The Mariner's Revenge Song", 2005),
           new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
           new Song("Avett Brothers", "Talk on Indolence", 2006),
           new Song("Gerry Rafferty", "Baker Street", 1998),
           new Song("City and Colour", "Talk on Indolence", 2007),
           new Song("Foo Fighters", "Baker Street", 1997),
           new Song("Queen", "Bohemian Rhapsody", 1975),
           new Song("Gerry Rafferty", "Baker Street", 1978)
   };

   @Test
   public void testArtistComparator()
   {
      Song[] expected = new Song[8];
      Arrays.sort(songs, new ArtistComparator());
      expected[0] = new Song("Avett Brothers", "Talk on Indolence", 2006);
      expected[1] = new Song("City and Colour", "Sleeping Sickness", 2007);
      expected[2] = new Song("Decemberists", "The Mariner's Revenge Song", 2005);
      expected[3] = new Song("Foo Fighters", "Baker Street", 1997);
      expected[4] = new Song("Gerry Rafferty", "Baker Street", 1998);
      expected[5] = new Song("Gerry Rafferty", "Baker Street", 1978);
      expected[6] = new Song("Queen", "Bohemian Rhapsody", 1975);
      expected[7] = new Song("Rogue Wave", "Love's Lost Guarantee", 2005);
      assertEquals(expected, songs);

   }

   @Test
   public void testLambdaTitleComparator() {
      Comparator <Song> TitleComparator = (s1,s2)->{
            if (s1.getTitle().compareTo(s2.getTitle()) > 0)
               return 1;
            else if (s1.getTitle().compareTo(s2.getTitle()) < 0)
               return -1;
            return 0;
         };


      Song[] expected1 = new Song[8];
      Arrays.sort(songs, TitleComparator);
      expected1[0] = new Song("Gerry Rafferty", "Baker Street", 1998);
      expected1[1] = new Song("Foo Fighters", "Baker Street", 1997);
      expected1[2] = new Song("Gerry Rafferty", "Baker Street", 1978);
      expected1[3] = new Song("Queen", "Bohemian Rhapsody", 1975);
      expected1[4] = new Song("Rogue Wave", "Love's Lost Guarantee", 2005);
      expected1[5] = new Song("City and Colour", "Sleeping Sickness", 2007);
      expected1[6] = new Song("Avett Brothers", "Talk on Indolence", 2006);
      expected1[7] = new Song("Decemberists", "The Mariner's Revenge Song", 2005);

      assertEquals(expected1, songs);
   }

   @Test
   public void testYearExtractorComparator() {

      Comparator<Song> YearExtractorComparator = Comparator.comparing(Song::getYear, (s1, s2) -> {
                 if (s1.compareTo(s2) > 0)
                    return -1;
                 else if (s1.compareTo(s2) < 0)
                    return 1;
                 return 0;
              });

      Song[] expected2 = new Song[8];
      Arrays.sort(songs, YearExtractorComparator);
      expected2[0] = new Song("City and Colour", "Sleeping Sickness", 2007);
      expected2[1] = new Song("Avett Brothers", "Talk on Indolence", 2006);
      expected2[2] = new Song("Decemberists", "The Mariner's Revenge Song", 2005);
      expected2[3] = new Song("Rogue Wave", "Love's Lost Guarantee", 2005);
      expected2[4] = new Song("Gerry Rafferty", "Baker Street", 1998);
      expected2[5] = new Song("Foo Fighters", "Baker Street", 1997);
      expected2[6] = new Song("Gerry Rafferty", "Baker Street", 1978);
      expected2[7] = new Song("Queen", "Bohemian Rhapsody", 1975);

      assertEquals(expected2, songs);
   }

   @Test
   public void testComposedComparator() {

      Song[] expected3 = new Song[2];
      expected3[0] = new Song("Gerry Rafferty", "Baker Street", 1998);
      expected3[1] = new Song("Gerry Rafferty", "Baker Street", 1978);

      ComposedComparator C = new ComposedComparator(null, null);
      Arrays.sort(songs1, C);
      assertEquals(expected3, songs1);

   }

   @Test
   public void testComposedComparator01() {

      Song[] expected4 = new Song[8];
      expected4[0] = new Song("Avett Brothers", "Talk on Indolence", 2006);
      expected4[1] = new Song("City and Colour", "Sleeping Sickness", 2007);
      expected4[2] = new Song("Decemberists", "The Mariner's Revenge Song", 2005);
      expected4[3] = new Song("Foo Fighters", "Baker Street", 1997);
      expected4[4] = new Song("Gerry Rafferty", "Baker Street", 1998);
      expected4[5] = new Song("Gerry Rafferty", "Baker Street", 1978);
      expected4[6] = new Song("Queen", "Love's Lost Guarantee", 2005);
      expected4[7] = new Song("Queen", "Bohemian Rhapsody", 1975);

      ComposedComparator C = new ComposedComparator(null, null);
      Arrays.sort(songs2, C);
      assertEquals(expected4, songs2);

   }

   @Test
   public void testThenComparing() {

      Comparator <Song> ThenComparingTitleCompare = (a, b) -> {
         if (a.getTitle().compareTo(b.getTitle()) > 0)
            return 1;
         else if (a.getTitle().compareTo(b.getTitle()) < 0)
            return -1;
         return 0;
      };

      Comparator <Song> ThenComparingArtistCompare = (a, b) -> {
         if (a.getArtist().compareTo(b.getArtist()) > 0)
            return 1;
         else if (a.getArtist().compareTo(b.getArtist()) < 0)
            return -1;
         return 0;
      };

      Song[] expected5 = new Song[8];
      expected5[0] = new Song("Foo Fighters", "Baker Street", 1997);
      expected5[1] = new Song("Gerry Rafferty", "Baker Street", 1998);
      expected5[2] = new Song("Gerry Rafferty", "Baker Street", 1978);
      expected5[3] = new Song("Queen", "Bohemian Rhapsody", 1975);
      expected5[4] = new Song("Rogue Wave", "Love's Lost Guarantee", 2005);
      expected5[5] = new Song("Avett Brothers", "Talk on Indolence", 2006);
      expected5[6] = new Song("City and Colour", "Talk on Indolence", 2007);
      expected5[7] = new Song("Decemberists", "The Mariner's Revenge Song", 2005);

      Arrays.sort(songs3, ThenComparingTitleCompare.thenComparing(ThenComparingArtistCompare));
      assertEquals(expected5, songs3);

   }

   @Test
   public void runSort()
   {
      Comparator <Song> ThenComparingTitleCompare01 = (a, b) -> {
         if (a.getTitle().compareTo(b.getTitle()) > 0)
            return 1;
         else if (a.getTitle().compareTo(b.getTitle()) < 0)
            return -1;
         return 0;
      };

      Comparator <Song> ThenComparingArtistCompare01 = (a, b) -> {
         if (a.getArtist().compareTo(b.getArtist()) > 0)
            return 1;
         else if (a.getArtist().compareTo(b.getArtist()) < 0)
            return -1;
         return 0;
      };

      Comparator <Song> ThenComparingYearCompare = (a, b) -> {
         if (a.getYear() > b.getYear())
            return 1;
         else if (a.getYear() < b.getYear())
            return -1;
         return 0;
      };

      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      songList.sort(ThenComparingArtistCompare01.thenComparing(ThenComparingTitleCompare01).thenComparing(ThenComparingYearCompare));

      assertEquals(songList, expectedList);
   }
}
