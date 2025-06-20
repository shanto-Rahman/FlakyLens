/** 
 * If we have an overflow for hours, the minutes and seconds must be reseted. Test for WFLY-5995
 */
@Test public void testWFLY5995_HourOverflow(){
Assert.assertNotNull(firstTimeout);
Assert.assertEquals(year,firstTimeout.get(Calendar.YEAR));
Assert.assertEquals(month,firstTimeout.get(Calendar.MONTH));
Assert.assertEquals(dayOfMonth,firstTimeout.get(Calendar.DAY_OF_MONTH));
Assert.assertEquals(20,firstTimeout.get(Calendar.HOUR_OF_DAY));
Assert.assertEquals(0,firstTimeout.get(Calendar.MINUTE));
Assert.assertEquals(20,firstTimeout.get(Calendar.SECOND));
}