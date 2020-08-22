package cn.enjoyedu.servlet3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com
 *
 *往期视频咨询芊芊老师  QQ：2130753077  VIP课程咨询 依娜老师QQ：2133576719
 *
 *类说明：
 */
@Controller
@RequestMapping(produces="text/html;charset=UTF-8")
/*记得要在WebInitializer中增加servlet.setAsyncSupported(true);*/
public class PushNewsController {

    //private DeferredResult<String>  deferredResult = new DeferredResult<String>();
    //private ThreadLocal<DeferredResult<String>>

    @RequestMapping("/pushnews")
    public String news(){
        return "pushNews";
    }



    //线程池处理用户实际业务
    ExecutorService executorService
            = Executors.newFixedThreadPool(2);

    @RequestMapping(value="/realTimeNews")
    @ResponseBody
    public DeferredResult<String> realtimeNews(){
        final DeferredResult<String> deferredResult
                = new DeferredResult<String>();
            //在线程池中执行异步任务
    	executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);//实际的业务处理
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int index = new Random().nextInt(Const.NEWS.length);
                    deferredResult.setResult(Const.NEWS[index]);

                }
    	});
        return deferredResult;
    }

}
