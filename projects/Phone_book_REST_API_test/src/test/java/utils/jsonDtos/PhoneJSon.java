package utils.jsonDtos;

public class PhoneJSon {

    private final String countryCode;
    private final String phoneNumber;
    private final int contactId;


    public PhoneJSon(String countryCode, String phoneNumber, int contactId) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        final String fieldCountryCode = "\"countryCode\" : \"";
        final String fieldPhoneNumber = "\"phoneNumber\" : \"";
        final String fieldContactId = "\"contactId\" : \"";

        stringBuilder = new StringBuilder();
        stringBuilder
                .append("{\n")

                .append(fieldCountryCode)
                .append(countryCode)
                .append("\", \n")

                .append(fieldPhoneNumber)
                .append(phoneNumber)
                .append("\",\n")

                .append(fieldContactId)
                .append(contactId)
                .append("\"")

                .append("\n}");

        return stringBuilder.toString();
    }
}
