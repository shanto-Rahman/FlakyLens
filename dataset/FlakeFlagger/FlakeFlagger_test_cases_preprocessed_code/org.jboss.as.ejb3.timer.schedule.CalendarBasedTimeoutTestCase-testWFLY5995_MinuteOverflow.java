/** 
 * If we have an overflow for minutes, the seconds must be reseted. Test for WFLY-5995
 */
@Test public void testWFLY5995_MinuteOverflow(){
Assert.assertNotNull(firstTimeout);
Assert.assertEquals(year,firstTimeout.get(Calendar.YEAR));
Assert.assertEquals(month,firstTimeout.get(Calendar.MONTH));
Assert.assertEquals(dayOfMonth,firstTimeout.get(Calendar.DAY_OF_MONTH));
Assert.assertEquals(10,firstTimeout.get(Calendar.HOUR_OF_DAY));
Assert.assertEquals(0,firstTimeout.get(Calendar.MINUTE));
Assert.assertEquals(0,firstTimeout.get(Calendar.SECOND));
}