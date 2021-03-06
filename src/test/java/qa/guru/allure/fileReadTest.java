package qa.guru.allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Feature("Work with Projects")
public class fileReadTest {
        private final fileReadHelper txtFile = new fileReadHelper();
        @Test
        @Story("Check reading from file")
        @DisplayName("This checks if string returned from file is correct")
        public void testString(){
                String txtToken = "";
                txtToken = txtFile.getStringFromFile("D:\\code\\qa-guru-allure-exercise\\src\\test\\java\\qa\\guru\\allure\\token.txt");
                System.out.println("This is what we got:" + txtToken);
                assertEquals("AAAAAAAAABBBBBBBBCCCCCCCCCCCCDDDDDDDDDDDD", txtToken);
        }


}