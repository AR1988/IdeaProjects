package utils.jsonDtos;

public class UserJSon {
    private String email;
    private String password;

    public UserJSon(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        final String fieldEmail = "\"email\" : \"";
        final String fieldPassword = "\"password\" : \"";

        stringBuilder = new StringBuilder();
        stringBuilder
                .append("{\n")

                .append(fieldEmail)
                .append(email)
                .append("\", \n")

                .append(fieldPassword)
                .append(password)
                .append("\"\n")

                .append("\n}");

        return stringBuilder.toString();
    }
}
