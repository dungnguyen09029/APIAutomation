package enums;

public enum Context {

    BOOK_ID,                                            // book id if sent create request or get specific book id information
    BOOK_INFORMATION,                                   // book information of specific book id
    TOKEN,                                              // token returned from authentication request
    BOOK_INFORMATION_PARTIAL_UPDATE,                    // information for partial update
}
