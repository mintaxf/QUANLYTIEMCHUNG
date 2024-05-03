package vn.viettuts.qlsv.controller;

import java.util.Date;

/**
 *
 * @author hung
 */
//giới hạn số lần đăng nhập sai trong 1 thời gian
public class LoginCheck {
    private static int fail_counter=0;
    private static Date fail_timestamp=null; 

    public void setCounter(int fail_counter)
    {
        this.fail_counter=fail_counter;
    }
    public int getCounter()
    {
        return this.fail_counter;
    }
    public boolean Check()
    {
           
              if(fail_timestamp==null && fail_counter==0)
           {
               fail_counter++;
               Date date=new Date();
               fail_timestamp=date;
               return true;
           }
          else if(fail_timestamp!=null)
          {
              Date date1= new Date();
              if ((date1.getTime()-fail_timestamp.getTime())/60000 >1)
              {
                  fail_timestamp=null;
                  fail_counter=0;
                  return true;
              }
              else if((date1.getTime()-fail_timestamp.getTime())/60000<=1)
              {
                  fail_counter++;
                  if(fail_counter>5)
                  {
                      return false;
                  }
                      return true;
                  
              }
              return true;
          }
        return true;
    }
}

