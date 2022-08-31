package response;

import java.io.Serializable;

/**
 * serializable class to server's responses
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 19L;

    public String getResponse() {
        return response;
    }

    private String response;

    /**
     * constructor
     * @param response
     */
    public Response(String response){
        this.response = response;
    }

    public Response() {}
}
