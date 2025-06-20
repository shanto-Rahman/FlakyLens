@Test public void testPublishReport() throws InterruptedException {
Thread.sleep(150);
executorService.shutdown();
Assert.assertEquals(1,((DummyReportPublisher)publisher).getReportCount);
Thread.sleep(100);
Assert.assertEquals(1,((DummyReportPublisher)publisher).getReportCount);
}