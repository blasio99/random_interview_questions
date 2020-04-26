public class EmployeeHierarchy {

    int findNextClosing(String stringToBeParsed, int startPoint) {
        int next = startPoint + 1;
        int inner = 0;
        while(next < stringToBeParsed.length()) {
            if (stringToBeParsed.charAt(next) == '(')
                inner += 1;
            if (stringToBeParsed.charAt(next) == ')' && inner != 0)
                inner -= 1;
            else if (stringToBeParsed.charAt(next) == ')' && inner == 0)
                return next;
            next += 1;
        }
        return -1;
    }

    int findNextOpening(String stringToBeParsed, int startPoint) {
        int next = startPoint + 1;
        if (stringToBeParsed.length() < 1) {
            return -1;
        } else {
            while (stringToBeParsed.charAt(next) != '(') {
                if (next == stringToBeParsed.length() - 1)
                    return -1;
                next += 1;
            }
            return next;
        }
    }

    void exterminateTheUnavailable(String stringToBeParsed){
        int openingParanthesis = 0;
        int closingParanthesis;
        System.out.println(stringToBeParsed.substring(0, stringToBeParsed.length()));

        while(openingParanthesis != -1) {
            closingParanthesis = findNextClosing(stringToBeParsed, openingParanthesis);

            if(stringToBeParsed.substring(openingParanthesis + 2, openingParanthesis + 13).equals("Unavailable")) {
                if (stringToBeParsed.substring(openingParanthesis, closingParanthesis).equals(stringToBeParsed)) {
                    stringToBeParsed = "";
                    break;
                }
                stringToBeParsed = stringToBeParsed.substring(0, openingParanthesis - 2) + stringToBeParsed.substring(closingParanthesis + 1);

            }
            openingParanthesis = findNextOpening(stringToBeParsed, openingParanthesis);
        }
        System.out.println(stringToBeParsed);
    }

    public static void main(String[] args) {
        EmployeeHierarchy employeeHierarchy = new EmployeeHierarchy();
        String inputString = "(“John”, (“Jasmine”, (“Jay”), (“Unavailable”)), (“Unavailable”, (“Jack”, (“Jeremy”))), (“Johanna”))";
        employeeHierarchy.exterminateTheUnavailable(inputString);
    }
}
