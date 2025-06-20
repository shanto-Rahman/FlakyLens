/** 
 * Check if the hour/minute/second is reseted correct if the day must be updated
 */
@Test public void testDayOverflow(){
Assert.assertNotNull(firstTimeout);
Assert.assertEquals(year,firstTimeout.get(Calendar.YEAR));
Assert.assertEquals(1,firstTimeout.get(Calendar.MONTH));
Assert.assertEquals(2,firstTimeout.get(Calendar.DAY_OF_MONTH));
Assert.assertEquals(3,firstTimeout.get(Calendar.HOUR_OF_DAY));
Assert.assertEquals(0,firstTimeout.get(Calendar.MINUTE));
Assert.assertEquals(0,firstTimeout.get(Calendar.SECOND));
}