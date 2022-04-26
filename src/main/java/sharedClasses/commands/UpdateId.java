package sharedClasses.commands;

import server.commands.ArgObjectForServer;

/**
 * A class for updating the value of a collection element whose ID is equal to the specified one.
 */
public class UpdateId extends Command<ArgObjectForServer> {
    public UpdateId() {
        super(true, 1, "UPDATE", "update the value for the collection element whose id is equal to the given one", true);
    }

    @Override
    public String execute(ArgObjectForServer argObject) {
        String result = "Element successfully updated";
        try {
            long id = Long.parseLong(argObject.getArgs()[1]);
            boolean resultOfRemoval = argObject.getCollectionManager().removeById(id);
            if (!resultOfRemoval) result = "This id wasn't found";
            argObject.getMusicBand().setId(id);
            argObject.getCollectionManager().add(argObject.getMusicBand());
        } catch (NumberFormatException e) {
            result = "Wrong format of id";
        }
        return result;
    }
}
