public void testLegacyCronString() throws Exception {
assertEquals(parseCalendar("20140310-12:00:00",TimeZone.getTimeZone("UTC")).getTime(),businessCalendar.resolveDuedate("0 0 12 1/1 * ? *"));
}