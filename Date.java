package SchulBib_Version_Schueler; /**
  *
  * Beschreibung
  *
  * @version 1.0 vom 12.03.2015
  * @Elisabeth Engel
  */
import java.util.*;
import java.text.DateFormat;
public class Date {
  private Calendar cal;
  
  public Date(){
    cal = Calendar.getInstance();
  }
  public Date(int day, int month, int year){
    this();
    cal.set(year, month-1, day);
  }
  public void setDate(int day, int month, int year){
    cal.set(year, month-1, day);
  }
  public void addDays(int numberOfDays) {
      cal.add(Calendar.DATE, numberOfDays);
  }
  public boolean equals(Date date) {
    Calendar c = date.getCal();
    System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    System.out.println(c.get(Calendar.DAY_OF_MONTH));
    if(cal.get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH) &&
    cal.get(Calendar.MONTH) == c.get(Calendar.MONTH) &&
    cal.get(Calendar.YEAR) == c.get(Calendar.YEAR)) {
       return true;
    } else {
       return false; 
    }    
  }
  public int compareTo(Date d){
    long millis1 = cal.getTimeInMillis();
    long millis2 = d.getCal().getTimeInMillis();
    long differenz = millis1 - millis2;
    int tage = (int)(differenz/1000/60/60/24);
    return tage; 
  }
  public Date clone() {
    Date d = new Date(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1,
                      cal.get(Calendar.YEAR));
    return d;
  }
  public String toString(){
    DateFormat meinDatumFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    return meinDatumFormat.format(cal.getTime());
  }
  public Calendar getCal(){
    return cal;
  }
} // end of class Date
