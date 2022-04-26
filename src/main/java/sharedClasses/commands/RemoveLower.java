package sharedClasses.commands;

import server.commands.ArgObjectForServer;

import java.util.Set;

/**
 * A class for removing from the collection all items whose albumsCount field values are less than the specified one.
 */
public class RemoveLower extends Command<ArgObjectForServer> {
    public RemoveLower() {
        super(true, 0, "REMOVE_LOWER", "remove from the collection all elements smaller than the specified one", true);
    }

    @Override
    public String execute(ArgObjectForServer argObject) {
        String result = "All lower objects were deleted";
        Set<Long> id = argObject.getCollectionManager().getIdByLower(argObject.getMusicBand());
        for (Long i : id) {
            argObject.getCollectionManager().removeById(i);
        }
        return result;
    }
}
