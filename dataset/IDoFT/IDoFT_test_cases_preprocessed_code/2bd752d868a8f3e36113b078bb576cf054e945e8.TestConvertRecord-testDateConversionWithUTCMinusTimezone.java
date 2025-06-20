@Test public void testDateConversionWithUTCMinusTimezone() throws Exception {
assertTrue(avroStream.hasNext());
assertEquals(1,avroStream.next().get("date"));
}