@Test public void throttleTimeWindowBatchTest2() throws InterruptedException {
if (inEvents != null) {
if (removeEvents != null) {
}
}
Thread.sleep(10000);
Assert.assertEquals(2,inEventCount);
Assert.assertEquals("WSO2",lastRemoveEvent.getData()[0]);
Assert.assertTrue(eventArrived);
}