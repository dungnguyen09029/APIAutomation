package enums;

public enum Header {
    CONTENT_TYPE("Content-Type", "application/json");

    private String headerName;
    private String headerValue;

    Header(String headerName, String headerValue) {
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getHeaderValue() {
        return headerValue;
    }

//        public static HEADER getByValue(String value) {
//            return Stream.of(HEADER.values()).filter(c -> c.headerName.equalsIgnoreCase(value)).findFirst().orElse(null);
//        }
//
//        public static HEADER getByValue(String value) {
//            return Stream.of(HEADER.values()).filter(c -> c.value().equalsIgnoreCase(value)).findFirst().orElse(null);
//        }
}
