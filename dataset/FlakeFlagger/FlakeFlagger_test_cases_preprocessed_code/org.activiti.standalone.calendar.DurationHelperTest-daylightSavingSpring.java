@Test public void daylightSavingSpring() throws Exception {
assertEquals(parseCalendar("20140309-06:45:00",TimeZone.getTimeZone("UTC")),dh.getCalendarAfter(testingClock.getCurrentCalendar(TimeZone.getTimeZone("US/Eastern"))));
}