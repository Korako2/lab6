package IOutils;

import collection.*;
import collection.collectionUtil.CollectionStorage;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class ObjectReader {
    Scanner scanner;

    public ObjectReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public MusicBand readObject() {
        return new MusicBand(readNameOfMusicBand(), readCoordinates(), ZonedDateTime.now(),
                readNumberOfParticipants(), readAlbumsCount(), readDescription(), readGenre(), readPerson());
    }

    public String readNameOfMusicBand() {
        while (true) {
            String name = readLine("Input name of MusicBand: ");
            if (name == null || name.equals("")) {
                System.out.println("Wrong format of input! Name can't be an empty line.");
            } else return name;
        }
    }

    public Long readNumberOfParticipants() {
        while (true) {
            try {
                Long numberOfParticipants = Long.parseLong(readLine("Input numberOfParticipants:"));
                if (numberOfParticipants <= 0) {
                    System.out.println("Wrong format of input! Number of participants can't be null and should be more than 0.");
                } else return numberOfParticipants;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It should be a long number.");
            }
        }
    }

    public Coordinates readCoordinates() {
        Float x = readXCoordinate();
        int y = readYCoordinate();
        return new Coordinates(x, y);
    }

    public long readAlbumsCount() {
        while (true) {
            try {
                long albumsCount = Long.parseLong(readLine("Input albumsCount: "));
                if (albumsCount > 0) return albumsCount;
                else System.out.println("Wrong format of input! AlbumsCount must be more than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It must be a long number more than 0.");
            }
        }
    }

    public String readDescription() {
        while (true) {
            String description = readLine("Input description: ");
            if (description == null) {
                System.out.println("Wrong format of input! Description can't be a null.");
            } else return description;
        }
    }

    public MusicGenre readGenre() {
        while (true) {
            try {
                MusicGenre genre = MusicGenre.valueOf(readLine("Input music genre(JAZZ, POST_ROCK, PUNK_ROCK)").toUpperCase());
                return genre;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong format of input! Choose a genre from the suggested list!");
            }

        }
    }

    public Person readPerson() {
        String name = readNameOfPerson();
        Double height = readHeight();
        EyeColor eyeColor = readEyeColor();
        HairColor hairColor = readHairColor();
        Country nationality = readNationality();
        Location location = readLocation();
        return new Person(name, height, eyeColor, hairColor, nationality, location);
    }

    public Country readNationality() {
        while (true) {
            try {
                Country nationality = Country.valueOf(readLine("Input country(GERMANY, INDIA, VATICAN):"));
                return nationality;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong format of input! Choose a country from the suggested list!");
            }
        }
    }

    public String readNameOfPerson() {
        while (true) {
            String name = readLine("Input name of person: ");
            if (name == null) {
                System.out.println("Wrong format of input! Name can't be a null.");
            } else return name;
        }
    }

    public HairColor readHairColor() {
        while (true) {
            try {
                HairColor hairColor = HairColor.valueOf(readLine("Input hair color(RED, BLACK, BLUE, ORANGE, WHITE):").toUpperCase());
                return hairColor;
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong format of input! Choose a hair color from the suggested list!");
            }
        }
    }

    public EyeColor readEyeColor() {
        while (true) {
            try {
                String line = readLine("Input eye color(RED, WHITE, BROWN):").toUpperCase();
                if (line.equals("")) return null;
                else {
                    EyeColor eyeColor = EyeColor.valueOf(line);
                    return eyeColor;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Wrong format of input! Choose an eye color from the suggested list!");
            }
        }
    }

    public Double readHeight() {
        while (true) {
            try {
                String line = readLine("Input height:");
                if (line.equals("")) return null;
                else {
                    Double height = Double.parseDouble(line.replace(",", "."));
                    if (height > 0) return height;
                    else {
                        System.out.println("Height must be more than 0.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! Height must be a number!");
            }
        }
    }

    public Location readLocation() {
        Float x = readXCoordinateOfLocation();
        int y = readYCoordinateOfLocation();
        Long z = readZCoordinateOfLocation();
        return new Location(x, y, z);
    }

    public Float readXCoordinateOfLocation() {
        while (true) {
            try {
                Float x = Float.parseFloat(readLine("Input x coordinate of location:").replace(",", "."));
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It should be a float number.");
            }
        }
    }

    public int readYCoordinateOfLocation() {
        while (true) {
            try {
                int y = Integer.parseInt(readLine("Input y coordinate of location:"));
                return y;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It should be a float number.");
            }
        }
    }

    public Long readZCoordinateOfLocation() {
        while (true) {
            try {
                Long z = Long.parseLong(readLine("Input z coordinate of location:"));
                return z;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It should be a Long number.");
            }
        }
    }

    public Float readXCoordinate() {
        while (true) {
            try {
                Float x = Float.parseFloat(readLine("Input x coordinate. Max field value: 146.").replace(",", "."));
                if (x > 146) {
                    System.out.println("Wrong format of input! Max field value: 146. ");
                } else return x;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It should be a float number.");
            }
        }
    }

    public int readYCoordinate() {
        while (true) {
            try {
                int y = Integer.parseInt(readLine("Input y coordinate. It must be integer."));
                return y;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format of input! It must be integer.");
            }
        }
    }


    public String readLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
