package cn.spring.mvc.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTest {  
    public static void main(String[] args) {  
        try {  
            String job_name = "动态任务调度";  
            System.out.println("【任务启动】开始");    
//            QuartzManager.addJob(job_name, "0/10 * * * * ?", QuartzJob.class);  
//            QuartzManager.addJobByTime(BatchJobGroup10001.class, job_name, "TESTTIGGERGROUPNAME", "TESTJOBGROUPNAME", 2000);
            QuartzManager.addJobByCron(QuartzJob.class, job_name, "TESTTIGGERGROUPNAME", "TESTJOBGROUPNAME", "30 * * * * ?");
//            Thread.sleep(6000);  
//            System.out.println("【修改时间】开始(每3秒输出一次)...2次");    
////            QuartzManager.modifyJobByTime(job_name, "10/2 * * * * ?");    
//            QuartzManager.modifyJobByTime(job_name, 3000);    
//            Thread.sleep(6000);    
//            System.out.println("【移除定时】开始...");    
//            QuartzManager.removeJob(job_name);    
//            System.out.println("【移除定时】成功");    
//            System.out.println("【再次添加定时任务】开始(每1秒输出一次)...6次");    
////            QuartzManager.addJobByTime(job_name, "*/10 * * * * ?", QuartzJob.class);    
//            QuartzManager.addJobByTime(job_name, 1000, QuartzJob.class);    
//            Thread.sleep(6000);    
//            System.out.println("【移除定时】开始...");    
//            QuartzManager.removeJob(job_name);    
//            System.out.println("【移除定时】成功");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
    	
    }  
      
    
    
    
    
    public static String formatDateByPattern(Date date,String dateFormat){    
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);    
        String formatTimeStr = null;    
        if (date != null) {    
            formatTimeStr = sdf.format(date);    
        }    
        return formatTimeStr;    
    }    
    public static String getCron(java.util.Date  date){    
        String dateFormat="ss mm HH dd MM ? yyyy";    
        return formatDateByPattern(date, dateFormat);    
     }    
}  
