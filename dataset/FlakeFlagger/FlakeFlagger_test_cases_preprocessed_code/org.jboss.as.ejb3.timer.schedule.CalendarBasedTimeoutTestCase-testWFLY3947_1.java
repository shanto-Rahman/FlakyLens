/** 
 * Testcase #1 for WFLY-3947
 */
@Test public void testWFLY3947_1(){
Assert.assertNotNull(firstTimeout);
Assert.assertEquals(year,firstTimeout.get(Calendar.YEAR));
Assert.assertEquals(Calendar.APRIL,firstTimeout.get(Calendar.MONTH));
Assert.assertEquals(1,firstTimeout.get(Calendar.DAY_OF_MONTH));
Assert.assertEquals(1,firstTimeout.get(Calendar.HOUR_OF_DAY));
Assert.assertEquals(30,firstTimeout.get(Calendar.MINUTE));
Assert.assertEquals(second,firstTimeout.get(Calendar.SECOND));
}