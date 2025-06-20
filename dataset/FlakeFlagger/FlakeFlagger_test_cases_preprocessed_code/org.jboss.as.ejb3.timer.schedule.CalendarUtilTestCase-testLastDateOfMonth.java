/** 
 * Tests that the    {@link CalendarUtil#getLastDateOfMonth(java.util.Calendar)}  returns the correctdate for various months.
 */
@Test public void testLastDateOfMonth(){
Assert.assertEquals("Unexpected last date for march",31,lastDateOfMarch);
Assert.assertEquals("Unexpected last date for april",30,lastDateOfApril);
Assert.assertEquals("Unexpected last date for non-leap february",28,lastDateOfNonLeapFebruary);
Assert.assertEquals("Unexpected last date for leap february",29,lastDateOfLeapFebruary);
}