@Test public void assertGetExecutorServiceHandlerForConcurrent() throws InterruptedException {
ExecutorService executorService=Executors.newFixedThreadPool(threadCount);
executorService.submit(new GetExecutorServiceHandlerTask(barrier,latch,set));
latch.await();
assertThat(set.size(),is(1));
assertThat(ExecutorServiceHandlerRegistry.getExecutorServiceHandler("test_job",new DefaultExecutorServiceHandler()),is(set.iterator().next()));
}