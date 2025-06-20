@Test public void testPublishReport() throws InterruptedException {
  ReportPublisher publisher=new DummyReportPublisher(100);
  StateContext dummyContext=Mockito.mock(StateContext.class);
  ScheduledExecutorService executorService=HadoopExecutors.newScheduledThreadPool(1,new ThreadFactoryBuilder().setDaemon(true).setNameFormat("Unit test ReportManager Thread - %d").build());
  publisher.init(dummyContext,executorService);
  Thread.sleep(150);
  executorService.shutdown();
  Assert.assertEquals(1,((DummyReportPublisher)publisher).getReportCount);
  verify(dummyContext,times(1)).refreshFullReport(null);
  Thread.sleep(100);
  Assert.assertEquals(1,((DummyReportPublisher)publisher).getReportCount);
}
