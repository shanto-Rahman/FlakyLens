public void testDaylightSavingSpringCron() throws Exception {
assertEquals(parseCalendar("20140309-16:00:00",TimeZone.getTimeZone("UTC")).getTime(),businessCalendar.resolveDuedate("0 0 12 1/1 * ? * DSTZONE:US/Eastern"));
}