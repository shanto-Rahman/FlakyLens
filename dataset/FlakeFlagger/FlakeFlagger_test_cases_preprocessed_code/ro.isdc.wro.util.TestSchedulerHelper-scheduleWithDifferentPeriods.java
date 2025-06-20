@Test public void scheduleWithDifferentPeriods() throws Exception {
Assert.assertEquals(10,helper.getPeriod());
Thread.sleep(20);
Assert.assertEquals(20,helper.getPeriod());
Thread.sleep(40);
}