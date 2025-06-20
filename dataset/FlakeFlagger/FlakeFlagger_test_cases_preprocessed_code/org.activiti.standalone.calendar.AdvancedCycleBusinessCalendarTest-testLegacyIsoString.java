public void testLegacyIsoString() throws Exception {
assertEquals(parseCalendar("20140311-00:00:00",TimeZone.getDefault()).getTime(),businessCalendar.resolveDuedate("R2/2014-03-10T00:00:00/P1D"));
}