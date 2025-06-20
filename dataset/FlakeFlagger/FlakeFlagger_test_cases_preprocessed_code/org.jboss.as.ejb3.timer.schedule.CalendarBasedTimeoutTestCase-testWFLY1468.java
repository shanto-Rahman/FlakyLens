/** 
 * WFLY-1468 Create a Timeout with a schedule start date in the past (day before) to ensure the time is set correctly. The schedule is on the first day of month to ensure that the calculated time must be moved to the next month. The test is run for each day of a whole year.
 */
@Test public void testWFLY1468(){
if (firstTimeout.get(Calendar.DAY_OF_MONTH) != 3 || firstTimeout.get(Calendar.HOUR_OF_DAY) != 2 || firstTimeout.get(Calendar.MINUTE) != 0 || firstTimeout.get(Calendar.SECOND) != 0) {
Assert.fail(firstTimeout.toString());
}
}