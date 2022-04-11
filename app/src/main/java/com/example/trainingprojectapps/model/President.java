package com.example.trainingprojectapps.model;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class President {
    private String name;
    private Date termBegin;
    private Date termEnd;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy");
    public void setName(String name) {
        this.name = name;
    }

    public String getTermBeginToString() {
        return dateFormatter.format(termBegin);
    }

    public void setTermBegin(Date termBegin) {
        this.termBegin = termBegin;
    }

    public String getTermEndToString() {
        return termEnd==null?"":dateFormatter.format(termEnd);
    }

    public void setTermEnd(Date termEnd) {
        this.termEnd = termEnd;
    }

    public President(String name,  String termBegin, String termEnd) {

        try {
            if (termBegin == null) {
                throw new InvalidParameterException("term begin cannot be null");
            }
            if (name == null) {
                throw new InvalidParameterException("name cannot be null");
            }
            this.name = name;
            this.termBegin = dateFormatter.parse(termBegin);
            this.termEnd = dateFormatter.parse(termEnd);

        }catch (InvalidParameterException e){
            throw e;
        }
        catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public static ArrayList<President> generateDataItem(){
        return  new ArrayList<President>(Arrays.asList(
                new President("George Washington" ,"April 30, 1789", "March 4, 1797"),
                new President("John Adams" ,"March 4, 1797", "March 4, 1801"),
                new President("Thomas Jefferson" ,"March 4, 1801", "March 4, 1809"),
                new President("James Madison" ,"March 4, 1809", "March 4, 1817"),
                new President("James Monroe" ,"March 4, 1817", "March 4, 1825"),
                new President("John Quincy Adams" ,"March 4, 1825", "March 4, 1829"),
                new President("Andrew Jackson" ,"March 4, 1829", "March 4, 1837"),
                new President("Martin Van Buren" ,"March 4, 1837", "March 4, 1841"),
                new President("William Henry Harrison" ,"March 4, 1841", "April 4, 1841"),
                new President("John Tyler" ,"April 4, 1841", "March 4, 1845"),
                new President("James K. Polk" ,"March 4, 1845", "March 4, 1849"),
                new President("Zachary Taylor" ,"March 4, 1849", "July 9, 1850"),
                new President("Millard Fillmore" ,"July 9, 1850", "March 4, 1853"),
                new President("Franklin Pierce" ,"March 4, 1853", "March 4, 1857"),
                new President("James Buchanan" ,"March 4, 1857", "March 4, 1861"),
                new President("Abraham Lincoln" ,"March 4, 1861", "April 15, 1865"),
                new President("Andrew Johnson" ,"April 15, 1865", "March 4, 1869"),
                new President("Ulysses S. Grant" ,"March 4, 1869", "March 4, 1877"),
                new President("Rutherford B. Hayes" ,"March 4, 1877", "March 4, 1881"),
                new President("James Garfield" ,"March 4, 1881", "September 19, 1881"),
                new President("Chester Arthur" ,"September 19, 1881", "March 4, 1885"),
                new President("Grover Cleveland" ,"March 4, 1885", "March 4, 1889"),
                new President("Benjamin Harrison" ,"March 4, 1889", "March 4, 1893"),
                new President("Grover Cleveland" ,"March 4, 1893", "March 4, 1897"),
                new President("William McKinley" ,"March 4, 1897", "September 14, 1901"),
                new President("Theodore Roosevelt" ,"September 14, 1901", "March 4, 1909"),
                new President("William Howard Taft" ,"March 4, 1909", "March 4, 1913"),
                new President("Woodrow Wilson" ,"March 4, 1913", "March 4, 1921"),
                new President("Warren G. Harding" ,"March 4, 1921", "August 2, 1923"),
                new President("Calvin Coolidge" ,"August 2, 1923", "March 4, 1929"),
                new President("Herbert Hoover" ,"March 4, 1929", "March 4, 1933"),
                new President("Franklin D. Roosevelt" ,"March 4, 1933", "April 12, 1945"),
                new President("Harry S. Truman" ,"April 12, 1945", "January 20, 1953"),
                new President("Dwight Eisenhower" ,"January 20, 1953", "January 20, 1961"),
                new President("John F. Kennedy" ,"January 20, 1961", "November 22, 1963"),
                new President("Lyndon B. Johnson" ,"November 22, 1963", "January 20, 1969"),
                new President("Richard Nixon" ,"January 20, 1969", "August 9, 1974"),
                new President("Gerald Ford" ,"August 9, 1974", "January 20, 1977"),
                new President("Jimmy Carter" ,"January 20, 1977", "January 20, 1981"),
                new President("Ronald Reagan" ,"January 20, 1981", "January 20, 1989"),
                new President("George Bush" ,"January 20, 1989", "January 20, 1993"),
                new President("Bill Clinton" ,"January 20, 1993", "January 20, 2001"),
                new President("George W. Bush" ,"January 20, 2001", "January 20, 2009"),
                new President("Barack Obama" ,"January 20, 2009", "January 20, 2017"),
                new President("Donald Trump" ,"January 20, 2017", "January 20, 2021"),
                new President("Joe Biden" ,"January 20, 2021", null)
        ));
    }

}

