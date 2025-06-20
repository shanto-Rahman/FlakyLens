/** 
 * Testcase #2 for WFLY-3947
 */
@Test public void testWFLY3947_2(){
Assert.assertNotNull(firstTimeout);
Assert.assertEquals(year,firstTimeout.get(Calendar.YEAR));
Assert.assertEquals(month,firstTimeout.get(Calendar.MONTH));
Assert.assertEquals(dayOfMonth,firstTimeout.get(Calendar.DAY_OF_MONTH));
Assert.assertEquals(3,firstTimeout.get(Calendar.HOUR_OF_DAY));
Assert.assertEquals(20,firstTimeout.get(Calendar.MINUTE));
Assert.assertEquals(second,firstTimeout.get(Calendar.SECOND));
}