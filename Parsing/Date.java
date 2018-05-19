import java.util.Scanner;
class Date {
static Scanner ob = new Scanner(System.in);
static int MAX_VALID_YR ;
static int MIN_VALID_YR ;
int d;int m;int y;String date;
static Table table_object = new Table();
public Date()
{
    d=0;
    m=0;
    y=0;
    MAX_VALID_YR = 0;
    MIN_VALID_YR = 0;
}
public Date(String s,int dd,int mm,int yy)
{
    if(validDate(s, dd, mm, yy)==true)
    {
     String s1 = Integer.toString(dd);
     String s2 = Integer.toString(mm);
     String s3 = Integer.toString(yy);
     String s4 = s1+"/"+s2+"/"+s3;
     date = s4;
    }
    else{ 
       this.d=-1;
       this.m=-1;
       this.y=-1;
    }
   this.MAX_VALID_YR = 9999;
   this.MIN_VALID_YR = 1800;
}
public  int accept(String s,int dd,int mm,int yy)
{
if(validDate(s, dd, mm, yy)==true)
{
    return 1;    
    
}
    else{
        return 0;
    }
}              
public static int validFormat (String s)
{
    
    int length = s.length();
    int f = s.indexOf('/');
    int l = s.lastIndexOf('/');
    String sub1 = s.substring(0,f);
    String sub3 = s.substring(l+1,length);
    String sub = s.substring(f+1,l);
    if((sub1.length()==2)&&(sub.length()==2)&&(sub3.length()==4))
       {
          return 1 ;
       }
       else
       {
           return 0;
       }    
}
public  boolean validDate(String s, int dd,int mm,int yy)
{
    this.MAX_VALID_YR = 9999;
    this.MIN_VALID_YR = 1800;
  if(validFormat(s)==1)
  {
    
    if (yy > MAX_VALID_YR || yy < MIN_VALID_YR)
        return false;
    if (mm < 1 || mm > 12)
        return false;
    if (dd < 1 || dd > 31)
        return false;
        if (mm == 2) {
            if (isLeap(yy))
                return (dd <= 29);
            else
                return (dd <= 28);
        }
 
        
        if (mm == 4 || mm == 6 || mm == 9 || mm == 11)
            return (dd <= 30);
 
        return true;

      }
      else{
            return false ; 
      }
    } 
    public  boolean isLeap(int year)
    {
      return(((year % 4 == 0) && (year % 100 != 0))
                                  || (year % 400 == 0));
                                  
    }
public void insert()
{
    System.out.println("Enter the values you want to insert");
    System.out.print(ob.next());
}
public int acceptTable(String s)
{
    
    int length = s.length();
    int f = s.indexOf('/');
    int l = s.lastIndexOf('/');
    String sub1 = s.substring(0,f);
    String sub3 = s.substring(l+1,length); 
    String sub = s.substring(f+1,l);
    int dd = Integer.parseInt(sub1);
    int mm = Integer.parseInt(sub);
    int yy = Integer.parseInt(sub3);
    
    accept(s,dd, mm, yy);
    validFormat(s);
    validDate(s, dd, mm, yy);
    if(d!=-1)
    
    return 1 ;
    
    else
        return 0;
    
}


    
}