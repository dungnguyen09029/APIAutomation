package apiEngine.model.responses;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListBookId {

    @JsonProperty("")
    public List<BookId> listBookId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListBookId() {
    }

    /**
     *
     * @param listBookId
     */
    public ListBookId(List<BookId> listBookId) {
        super();
        this.listBookId = listBookId;
    }

}
