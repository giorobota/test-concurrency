package main.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.dao.ExecutionContextDao;
import org.springframework.batch.core.repository.dao.JobExecutionDao;
import org.springframework.batch.core.repository.dao.JobInstanceDao;
import org.springframework.batch.core.repository.dao.StepExecutionDao;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.InitializingBean;

import java.util.Collection;
import java.util.List;
import java.util.Set;


class DummyInstanceDo implements JobInstanceDao {

    @Override
    public JobInstance createJobInstance(String s, JobParameters jobParameters) {
        return null;
    }

    @Override
    public JobInstance getJobInstance(String s, JobParameters jobParameters) {
        return null;
    }

    @Override
    public JobInstance getJobInstance(Long aLong) {
        return null;
    }

    @Override
    public JobInstance getJobInstance(JobExecution jobExecution) {
        return null;
    }

    @Override
    public List<JobInstance> getJobInstances(String s, int i, int i1) {
        return null;
    }

    @Override
    public JobInstance getLastJobInstance(String jobName) {
        return JobInstanceDao.super.getLastJobInstance(jobName);
    }

    @Override
    public List<String> getJobNames() {
        return null;
    }

    @Override
    public List<JobInstance> findJobInstancesByName(String s, int i, int i1) {
        return null;
    }

    @Override
    public int getJobInstanceCount(String s) throws NoSuchJobException {
        return 0;
    }
}

class DummyExecutionDao implements JobExecutionDao {

    @Override
    public void saveJobExecution(JobExecution jobExecution) {

    }

    @Override
    public void updateJobExecution(JobExecution jobExecution) {

    }

    @Override
    public List<JobExecution> findJobExecutions(JobInstance jobInstance) {
        return null;
    }

    @Override
    public JobExecution getLastJobExecution(JobInstance jobInstance) {
        return null;
    }

    @Override
    public Set<JobExecution> findRunningJobExecutions(String s) {
        return null;
    }

    @Override
    public JobExecution getJobExecution(Long aLong) {
        return null;
    }

    @Override
    public void synchronizeStatus(JobExecution jobExecution) {

    }
}

class DummyStepExecutionDao implements StepExecutionDao, InitializingBean{

    @Override
    public void saveStepExecution(StepExecution stepExecution) {

    }

    @Override
    public void saveStepExecutions(Collection<StepExecution> collection) {

    }

    @Override
    public void updateStepExecution(StepExecution stepExecution) {

    }

    @Override
    public StepExecution getStepExecution(JobExecution jobExecution, Long aLong) {
        return null;
    }

    @Override
    public StepExecution getLastStepExecution(JobInstance jobInstance, String stepName) {
        return StepExecutionDao.super.getLastStepExecution(jobInstance, stepName);
    }

    @Override
    public void addStepExecutions(JobExecution jobExecution) {

    }

    @Override
    public int countStepExecutions(JobInstance jobInstance, String stepName) {
        return StepExecutionDao.super.countStepExecutions(jobInstance, stepName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

class DummyExecutionContextDao implements ExecutionContextDao {

    @Override
    public ExecutionContext getExecutionContext(JobExecution jobExecution) {
        return null;
    }

    @Override
    public ExecutionContext getExecutionContext(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void saveExecutionContext(JobExecution jobExecution) {

    }

    @Override
    public void saveExecutionContext(StepExecution stepExecution) {

    }

    @Override
    public void saveExecutionContexts(Collection<StepExecution> collection) {

    }

    @Override
    public void updateExecutionContext(JobExecution jobExecution) {

    }

    @Override
    public void updateExecutionContext(StepExecution stepExecution) {

    }
}

