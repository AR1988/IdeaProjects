package HelloWorld;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();

        System.out.println("________________________________________________________________________________________________________");
        System.out.printf("%15s%15s%20s%15s%15s%15s\n",
                "Year",
                "Month",
                "Day of Month",
                "Day of week",
                "Day of year",
                "Days in Year");
        System.out.println("________________________________________________________________________________________________________");
        System.out.printf("%15s%17s%12s%19s%12s%15s\n",
                now.getYear(),
                now.getMonth(),
                now.getDayOfMonth(),
                LocalDateTime.now().getDayOfWeek(),
                LocalDateTime.now().getDayOfYear(),
                LocalDate.EPOCH.lengthOfYear()
        );
        System.out.println("________________________________________________________________________________________________________");

        System.out.println("\nTime: ".toUpperCase());
        while (true) {
            System.out.printf("\r%1$tH:%1$tM:%1$tS", LocalTime.now(ZoneId.systemDefault()));
            Thread.sleep(1000);
        }
    }
}
