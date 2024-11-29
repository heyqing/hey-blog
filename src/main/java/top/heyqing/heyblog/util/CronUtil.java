package top.heyqing.heyblog.util;

import org.quartz.CronExpression;

import java.util.Date;

/**
 * ClassName:CronUtil
 * Package:top.heyqing.heyblog.util
 * Description:
 *
 * @Date:2024/11/28
 * @Author:Heyqing
 */
public class CronUtil {

    public static boolean isValid(String cronExpression) {
        return CronExpression.isValidExpression(cronExpression);
    }

    public static String getInvalidMessage(String cronExpression) {
        try {
            new CronExpression(cronExpression);
            return null;
        } catch (Exception pe) {
            return pe.getMessage();
        }
    }

    public static Date getNextExecution(String cronExpression) {
        try {
            CronExpression cron = new CronExpression(cronExpression);
            return cron.getNextValidTimeAfter(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}