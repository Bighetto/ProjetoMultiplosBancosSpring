package projectspring.estudo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import projectspring.estudo.service.RequestProcess;

@Component
@EnableAsync
@EnableScheduling
public class Scheduler {

    private final Logger LOG = LoggerFactory.getLogger(Scheduler.class);
    private RequestProcess requestProcess;

    @Autowired
    public Scheduler(RequestProcess requestProcess) {
        this.requestProcess = requestProcess;
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void executeProcess() {

        try {
            LOG.info("---------- Get Capture Date ----------");
            requestProcess.process();
            LOG.info("---------- Finished get Capture Date  ----------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
