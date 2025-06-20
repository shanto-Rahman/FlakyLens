@Test public void testScheduledTimezoneDifferentThanCurrentSystem(){
Assert.assertNotNull("first timeout is null",firstTimeout);
logger.info("First timeout is " + firstTimeout.getTime());//RW
logger.info("Next timeout is " + nextTimeout.getTime());//RW
Assert.assertEquals("[WFLY-2840] Next timeout should be: " + expectedCal.getTime(),expectedCal.getTime(),nextTimeout.getTime());
}