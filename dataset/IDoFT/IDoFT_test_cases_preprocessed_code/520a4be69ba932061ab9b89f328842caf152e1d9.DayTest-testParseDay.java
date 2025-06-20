/** 
 * Problem for date parsing. <p> This test works only correct if the short pattern of the date format is "dd/MM/yyyy". If not, this test will result in a false negative.
 * @throws ParseException on parsing errors.
 */
@Test public void testParseDay() throws ParseException {
if (reference.equals(gc.getTime())) {
assertEquals(37256,d.getSerialDate().toSerial());
}
assertEquals(37256,d.getSerialDate().toSerial());
}