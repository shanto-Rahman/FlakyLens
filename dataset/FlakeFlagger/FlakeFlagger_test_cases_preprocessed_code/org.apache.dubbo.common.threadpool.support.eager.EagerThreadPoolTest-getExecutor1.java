@Test public void getExecutor1() throws Exception {
assertThat(executor,instanceOf(EagerThreadPoolExecutor.class));
assertThat(executor.getCorePoolSize(),is(1));
assertThat(executor.getMaximumPoolSize(),is(2));
assertThat(executor.getKeepAliveTime(TimeUnit.MILLISECONDS),is(1000L));
assertThat(executor.getQueue().remainingCapacity(),is(1));
assertThat(executor.getQueue(),Matchers.<BlockingQueue<Runnable>>instanceOf(TaskQueue.class));
assertThat(executor.getRejectedExecutionHandler(),Matchers.<RejectedExecutionHandler>instanceOf(AbortPolicyWithReport.class));
executor.execute(new Runnable(){
  @Override public void run(){
    Thread thread=Thread.currentThread();
    assertThat(thread,instanceOf(InternalThread.class));
    assertThat(thread.getName(),startsWith("demo"));
    latch.countDown();
  }
}
);
Thread thread=Thread.currentThread();
assertThat(thread,instanceOf(InternalThread.class));
assertThat(thread.getName(),startsWith("demo"));
latch.countDown();
latch.await();
assertThat(latch.getCount(),is(0L));
}