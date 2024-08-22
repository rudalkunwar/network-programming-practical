// Write a simple program to illustrate x-www-form-urlencoded strings.
import java.io.*;
import java.net.*;

public class Lab8 {
    public static void main(String[] args) throws UnsupportedEncodingException {
            System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*asterisks%percent+pluses/slashes(parentheses)s=equals", "UTF-8"));
            System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
            System.out.println(URLEncoder.encode("This:string:has:colons&ampersands.periods", "UTF-8"));
            System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-8"));
            System.out.println(URLEncoder.encode("Thiséstringéhasé non-ASCII characters", "UTF-8"));
    }
}