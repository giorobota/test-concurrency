package main.job;

import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Collection;

@Configuration
@Component
public class TestJobProvider {


    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
        return new MapJobRepositoryFactoryBean(transactionManager()).getObject();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        return executor;
    }


    @Bean
    public Step getStep() throws Exception {
        String testString = "1234567890";
        return new StepBuilder("testAsyncStep")
                .<Character, Character>chunk(10)
                .reader(new AsyncItemReader(testString))
                .processor(new AsyncItemProcessor())
                .writer(new DummyWriter())
                .repository(jobRepository())
                .transactionManager(new JdbcTransactionManager())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job testAsyncJob() throws Exception {
        return new JobBuilder("testAsyncJob").repository(jobRepository()).start(getStep()).build();
    }
}
