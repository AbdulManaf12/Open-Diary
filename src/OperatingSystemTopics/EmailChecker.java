package OperatingSystemTopics;

public class EmailChecker
{
    private static FilingData f = new FilingData();

    public static boolean Validation(String email,String password)
    {
        String s[] = f.SearchRecord(email).split(",");
        if (s != null && password.equalsIgnoreCase(s[Constants.Password]))
        {
            return true;
        }
        return false;
    }
    public static void Register(String query)
    {
        f.AddRecords(query);
    }
}