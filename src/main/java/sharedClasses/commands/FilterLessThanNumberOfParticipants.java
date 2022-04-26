package sharedClasses.commands;

import server.commands.ArgObjectForServer;
import sharedClasses.data.MusicBand;

import java.util.List;

/**
 * A class for displaying elements whose numberOfParticipants field value is less than the specified one.
 */
public class FilterLessThanNumberOfParticipants extends Command<ArgObjectForServer> {
    public FilterLessThanNumberOfParticipants() {
        super(false, 1, "FILTER_LESS_THAN_NUMBER_OF_PARTICIPANTS", "output elements whose numberOfParticipants field value is less than the specified one", true);
    }

    @Override
    public String execute(ArgObjectForServer argObject) {

        StringBuilder result = new StringBuilder();
        try {
            Long number = Long.parseLong(argObject.getArgs()[1]);
            List<MusicBand> filterResult = argObject.getCollectionManager().FilterLessThanNumberOfParticipants(number);
            for (MusicBand musicBand : filterResult) result.append(musicBand.toString()).append("\n");
        } catch (NumberFormatException e) {
            result = new StringBuilder("Wrong format of number of participants\n");
        }

        if (result.length() == 0) return "Collection is empty\n";
        return result.substring(0, result.toString().length() - 1);
    }
}
