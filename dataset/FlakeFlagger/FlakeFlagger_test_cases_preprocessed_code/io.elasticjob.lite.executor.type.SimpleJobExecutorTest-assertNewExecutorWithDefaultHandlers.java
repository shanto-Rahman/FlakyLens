@Test public void assertNewExecutorWithDefaultHandlers() throws NoSuchFieldException {
assertThat(ReflectionUtils.getFieldValue(simpleJobExecutor,AbstractElasticJobExecutor.class.getDeclaredField("executorService")),instanceOf(new DefaultExecutorServiceHandler().createExecutorService("test_job").getClass()));
assertThat(ReflectionUtils.getFieldValue(simpleJobExecutor,AbstractElasticJobExecutor.class.getDeclaredField("jobExceptionHandler")),instanceOf(DefaultJobExceptionHandler.class));
}