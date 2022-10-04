package e1;

public class DateUtilities {

    public static boolean isLeap(int year) {
        if((year%4) == 0){
            if((year%100) == 0){
                return (year % 400) == 0;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }
    public static int numberOfDays (int month, int year)throws IllegalArgumentException{
        if (month <=0 || month >12 )  {
            throw new IllegalArgumentException("Error");
        }
        if(month == 2) {
            if(isLeap(year)){
                return 29;
            }else{
                return 28;
            }
        } else if (month <= 7) {
            if(month % 2 == 0){
                return 30;
            }else{
                return 31;
            }
        }else{
            if(month % 2 == 0){
                return 31;
            }else{
                return 30;
            }
        }
    }

    public static String convertToISODate(String dateText){
        StringBuilder sb = new StringBuilder();
        String[] split = dateText.split(" ");
        String month = switch (split[0]) {
            case "January" -> "01";
            case "February" -> "02";
            case "March" -> "03";
            case "April" -> "04";
            case "May" -> "05";
            case "June" -> "06";
            case "July" -> "07";
            case "August" -> "08";
            case "September" -> "09";
            case "October" -> "10";
            case "November" -> "11";
            default -> "12";
        };

        sb.append(split[2]).append("-").append(month).append("-").append(split[1], 0, 2);
        return sb.toString();

    }

    public static boolean checkISODate (String ISODate) {
        if(ISODate.length() != 10 ){
            return false;
        }else{
            int month, days, year;
            year = Integer.parseInt(ISODate.substring(0,4));
            month = Integer.parseInt(ISODate.substring(5, 7));
            days = Integer.parseInt(ISODate.substring(8,10));
            if (month <= 0 || month > 12 || year > 2022){
                return false;
            }
            return days <= numberOfDays(month, year);
        }
    }
}
