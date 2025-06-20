@Test public void throttleTimeWindowBatchTest1() throws InterruptedException {
if (inEvents != null) {
if (removeEvents != null) {
}
}
Thread.sleep(500);
Thread.sleep(6000);
Thread.sleep(6000);
Assert.assertEquals(4,inEventCount);
Assert.assertEquals(2,removeEventCount);
Assert.assertTrue(eventArrived);
}