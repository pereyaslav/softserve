import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmail {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[A-Za-z-]([A-za-z0-9]+\\.?)*[A-za-z0-9]@{1}[A-Za-z0-9]([A-Za-z0-9-]+)*\\.([A-Za-z0-9-]+?\\.)*([a-z]{2,})$";
    // "^[A-Za-z-]([A-za-z0-9]+\\.?)*@{1}[A-Za-z0-9]([A-Za-z0-9-]+)*\\.([A-Za-z0-9-]+?\\.)*([a-z]{2,})$";


    public ValidEmail() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean checkEmail(String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

}
