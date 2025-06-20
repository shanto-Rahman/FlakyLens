/** 
 * Problem for date parsing. <p> This test works only correct if the short pattern of the date format is "dd/MM/yyyy". If not, this test will result in a false negative.
 * @throws ParseException on parsing errors.
 */
@Test public void testParseDay() throws ParseException {
  GregorianCalendar gc=new GregorianCalendar(2001,12,31);
  SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
  Date reference=format.parse("31/12/2001");
  if (reference.equals(gc.getTime())) {
    Day d=Day.parseDay("31/12/2001");
    assertEquals(37256,d.getSerialDate().toSerial());
  }
  Day d=Day.parseDay("2001-12-31");
  assertEquals(37256,d.getSerialDate().toSerial());
}
