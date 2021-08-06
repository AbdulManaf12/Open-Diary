package OperatingSystemTopics;

import java.io.*;
import java.net.*;

class Server
{
    public static void StartServer() {
        try
        {
            ServerSocket ss = new ServerSocket(888);
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            while (true) {
                String request = br.readLine();
                if (request != null && !request.equalsIgnoreCase(Constants.STOP))
                {
                    String issue = request.substring(request.indexOf('(')+1,request.indexOf(')'));
                    request = request.substring(0,request.indexOf('('));
                    System.out.println(request);
                    ps.println(SolveIssue(request,issue));
                }
                else
                {
                    ps.close();
                    br.close();
                    ss.close();
                    s.close();
                    break;
                }
            }
        }
        catch (IOException ioException)
        {
            System.err.println("Server has issue");
        }
    }

    public static String SolveIssue(String command,String issue){
        String text = "";
        if (issue != null && command != null) {
            switch (command){
                case "Login":
                    text = (EmailChecker.Validation
                            (issue.split(",")[0],issue.split(",")[1]))
                            ? "Yes" : "No";
                   break;
                case "Signup":
                    EmailChecker.Register(issue);
                    text = "Done";
                    break;
                case "Delete":
                        new FilingData().deleteRecord(issue);
                        text = "Done";
                    break;
                case "Get":
                        text = new FilingData().SearchRecord(issue);
                    break;
            }
        }
        return text;
    }
}
