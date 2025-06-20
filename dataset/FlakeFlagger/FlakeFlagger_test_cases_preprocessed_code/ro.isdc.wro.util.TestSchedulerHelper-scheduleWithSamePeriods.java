@Test public void scheduleWithSamePeriods() throws Exception {
Assert.assertEquals(10,helper.getPeriod());
Thread.sleep(20);
Assert.assertEquals(10,helper.getPeriod());
Thread.sleep(30);
}