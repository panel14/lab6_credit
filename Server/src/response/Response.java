package response;

import java.io.Serializable;

public class Response implements Serializable {

    private static final long serialVersionUID = 19L;

    public String getResponse() {
        return response;
    }

    private String response;

    public Response(String response){
        this.response = response;
    }

    public Response() {}
}
