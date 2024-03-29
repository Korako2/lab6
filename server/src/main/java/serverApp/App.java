package serverApp;

import collectionUtil.CollectionManager;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        int port = 0;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "Specify the port when launching the jar file.");
            System.exit(-1);
        }
        CollectionManager collectionManager = new CollectionManager();
        Map env = System.getenv();
        String fileName = (String) env.get("FILE_NAME");
        if (fileName == null) {
            logger.log(Level.SEVERE, "No file name in environment variable FILE_NAME");
            System.exit(-1);
        }
        Pattern pattern = Pattern.compile("/*/dev/*");
        File file = new File(fileName);
        Matcher matcher = pattern.matcher(file.getAbsolutePath());
        if (matcher.find()) {
            logger.log(Level.SEVERE, "Incorrect file name or data in file.");
            System.exit(-1);
        }
        try {
            if (!collectionManager.fillCollection(fileName)) {
                logger.log(Level.SEVERE, "Incorrect file name or data in file.");
                System.exit(-1);
            }
        } catch (IOException | ParseException | NumberFormatException e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(-1);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Some exception: " + e.getMessage());
            System.exit(-1);
        }
        Server server = new Server(port, collectionManager);
        try {
            server.run();
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
