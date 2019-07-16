package com.sbm.demo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect //告诉SpringBoot这是一个切面类
@Component //将这个类转成Spring容器中的bean
public class LogAspect {

    //下面是记录日志的主体
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 使用RocketMq的生产者
     */
    @Autowired
    private DefaultMQProducer defaultMQProducer;


    //切点入口 web包下面所有类的所有方法
    private final String pointcut1 = "execution(public * com.sbm.demo.web.UserFundController.fundUpdateAdd(..))";


    //切点入口 web包下面所有类的所有方法
    private final String pointcut2 = "execution(public * com.sbm.demo.web.UserFundController.fundUpdateCut(..))";



    //用户购入已购基金的切入点
    @Pointcut(value = pointcut1)
    public void userByFund() {
    }

    //用户取出已购基金的切入点
    @Pointcut(value = pointcut2)
    public void userCutFund() {
    }



    //设置切入点的通知
    @Around(value = "userByFund()")  //这个代表的环绕通知，指代上面所有的方法进行的通知记录
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result = null;

        //这个StringBuilder是用来记录一次请求
        StringBuilder sbLog = new StringBuilder("\n");

        try {

            sbLog.append(String.format("请求的类名：%s\r\n", proceedingJoinPoint.getTarget().getClass().getName()));

            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            sbLog.append(String.format("请求的方法：%s\r\n", methodSignature.getMethod().getName()));

            //下面是请求的参数
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object o : args) {
                sbLog.append(String.format("参数：%s\r\n", JSON.toJSON(o)));
            }

            long startTime = System.currentTimeMillis();

            result = proceedingJoinPoint.proceed();  //让目标方法执行,也就是切入点的那个方法，result代表方法返回的值

            long endTime = System.currentTimeMillis();
            sbLog.append(String.format("返回：%s\r\n", JSON.toJSON(result)));
            sbLog.append(String.format("耗时：%ss", endTime - startTime));
        } catch (Exception ex) {
            sbLog.append(String.format("异常：%s", ex.getMessage()));
        } finally {
            System.out.println("logbackkkkkkkkkkkkkkkkkkkkkkkkk"+sbLog.toString());
            logger.info("logbackkkkkkkkkkkkkkkkkkkkkkkkk"+sbLog.toString());
        }
        return result;
    }


    //设置切入点的通知
    @Around(value = "userCutFund()")  //这个代表的环绕通知，指代上面所有的方法进行的通知记录
    public Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;

        //这个StringBuilder是用来记录一次请求
        StringBuilder sbLog = new StringBuilder("\n");

        try {

            sbLog.append(String.format("请求的类名：%s\r\n", proceedingJoinPoint.getTarget().getClass().getName()));

            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            sbLog.append(String.format("请求的方法：%s\r\n", methodSignature.getMethod().getName()));

            //下面是请求的参数
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object o : args) {
                sbLog.append(String.format("请求的参数：%s\r\n", JSON.toJSON(o)));
            }

            long startTime = System.currentTimeMillis();

            result = proceedingJoinPoint.proceed();  //让目标方法执行,也就是切入点的那个方法，result代表方法返回的值

            long endTime = System.currentTimeMillis();
            sbLog.append(String.format("返回：%s\r\n", JSON.toJSON(result)));
            sbLog.append(String.format("耗时：%ss", endTime - startTime));

            //TODO 封装发送的信息
            Message sendMsg = new Message("DemoTopic", "tag1", sbLog.toString().getBytes());
            //TODO 默认3秒超时，这里是发送信息
            SendResult sendResult = defaultMQProducer.send(sendMsg);

            sbLog.append(String.format("利用RocketMQ发送消息的返回结果：%s\r\n",sendResult.toString()));
        } catch (Exception ex) {
            sbLog.append(String.format("异常：%s", ex.getMessage()));
        } finally {
            logger.info("logbackkkkkkkkkkkkkkkkkkkkkkkkk"+sbLog.toString());
        }
        return result;
    }
}


















