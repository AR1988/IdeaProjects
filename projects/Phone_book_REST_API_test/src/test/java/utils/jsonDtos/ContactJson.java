package utils.jsonDtos;

import org.json.JSONObject;

public class ContactJson {

    private int id;
    private String contactFirstName;
    private String contactLastName;
    private String description;

    private StringBuilder stringBuilder;

    public ContactJson() {
    }

    public ContactJson(int id, String contactFirstName, String contactLastName, String description) {
        this.id = id;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.description = description;
    }

    public ContactJson(String contactFirstName, String contactLastName, String description) {
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.description = description;
    }

    @Override
    public String toString() {
        final String fieldFirstName = "\"firstName\" : \"";
        final String fieldLastName = "\"lastName\" : \"";
        final String fieldDescription = "\"description\" : \"";
        final String fieldId = "\"id\" : \"";

        stringBuilder = new StringBuilder();
        stringBuilder
                .append("{\n")

                .append(fieldId)
                .append(id)
                .append("\", \n")

                .append(fieldFirstName)
                .append(contactFirstName)
                .append("\", \n")

                .append(fieldLastName)
                .append(contactLastName)
                .append("\", \n")

                .append(fieldDescription)
                .append(description)

                .append("\"\n}");
        return stringBuilder.toString();
    }

    public String fromJson(JSONObject jsonObj) {
        this.id = (int) jsonObj.get("id");
        this.contactFirstName = jsonObj.getString("firstName");
        this.contactLastName = jsonObj.getString("lastName");
        this.description = jsonObj.getString("description");

        stringBuilder = new StringBuilder();

        return stringBuilder
                .append("Contact Details :")
                .append("\nContact id : ").append(id)
                .append("\nContact first name : ").append(contactFirstName)
                .append("\nContact last name : ").append(contactLastName)
                .append("\nContact description : ").append(description)
                .toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
