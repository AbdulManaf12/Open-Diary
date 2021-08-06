package OperatingSystemTopics;

public class Cryptography
{
	public static String encrypt(String msg)
	{
		String returned = "";
		for(int  i = 0 ; i < msg.length();i++)
		{
			returned +=(char)(msg.charAt(i)+2);
		}
		return returned;
	}
	public static String decrypt(String msg)
	{
		String returned = "";
		for(int  i = 0 ; i < msg.length();i++)
		{
			returned +=(char)(msg.charAt(i)-2);
		}
		return returned;
	}
}