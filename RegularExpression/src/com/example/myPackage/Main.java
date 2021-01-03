package com.example.myPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        String yourString = string.replace("I","You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12hIIiiikl992";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDee","YYY"));
        System.out.println(alphanumeric.matches("^abcDee")); // ret. false pt ca nu se machuieste tot stringul
        System.out.println(alphanumeric.replaceAll("ikl992$","THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]","Y"));
        System.out.println(alphanumeric.replaceAll("[aei][bF]","Y"));

        System.out.println("harry".replaceAll("[Hh]arry","Harry"));

        String newAlphanumeric = "abcDeeeF12hIIjiiikl992";
        System.out.println(newAlphanumeric.replaceAll("[^ej]","X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "x"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]","X")); // case sensitivity is ignored
        System.out.println(newAlphanumeric.replaceAll("[0-9]","x"));
        System.out.println(newAlphanumeric.replaceAll("\\d","x"));
        System.out.println(newAlphanumeric.replaceAll("\\D","x"));


        String hasWhiteSpace = "I have blanks and \t a tab, and also a new line \n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));
        System.out.println(hasWhiteSpace.replaceAll("\t","x"));
        System.out.println(hasWhiteSpace.replaceAll("\\S",""));
        System.out.println(hasWhiteSpace.replaceAll("\\W","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b","x")); // pune la final si incepu de cuvant x

        // quantifier
        String thirdAlphaNumberString = "abcDeeeF12Ghhiiiijkl992";

        System.out.println(thirdAlphaNumberString.replaceAll("^abcDe{3}","YYY")); //{3} represents number of preceding character to match
        System.out.println(thirdAlphaNumberString.replaceAll("^abcDe+","YYY")); // + represents one or more e's
        System.out.println(thirdAlphaNumberString.replaceAll("^abcDe*","YYY")); // * indiferent daca avem e sau nu
        System.out.println(thirdAlphaNumberString.replaceAll("^abcDe{2,5}","YYY"));
        System.out.println(thirdAlphaNumberString.replaceAll("h+i*j","YYY"));

        StringBuilder htmlText = new StringBuilder("<h1> My Heading </h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is another paragraph about something else</p>");
        htmlText.append("<p>Here is a summary</p>");
        htmlText.append("<h2>zzazazaza</h2>");

        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()){
            System.out.println("Occurence: " + groupMatcher.group(1));
        }
    }
}
