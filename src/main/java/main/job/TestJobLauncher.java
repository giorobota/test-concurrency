package main.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class TestJobLauncher implements CommandLineRunner {

    private final JobLauncher jobLauncher;

    private final Job testAsyncJob;

    public TestJobLauncher(
            @Qualifier("testAsyncJob") Job testAsyncJob,
            JobRepository repository,
            TaskExecutor taskExecutor
    ) {
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(repository);
        launcher.setTaskExecutor(taskExecutor);
        this.jobLauncher = launcher;
        this.testAsyncJob = testAsyncJob;
    }

    @Override
    public void run(String... args) throws Exception {
        jobLauncher.run(testAsyncJob, new JobParameters());
        Thread.sleep(1000);
    }
}
