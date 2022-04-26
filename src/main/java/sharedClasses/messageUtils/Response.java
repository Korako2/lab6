package sharedClasses.messageUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * The class of the response to the server.
 */
@RequiredArgsConstructor
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter
    private final String responseHead;
    @Getter
    private final String responseBody;
    public String toString() {
        return "Response[" + responseHead + ", " + responseBody + "]";
    }
}
