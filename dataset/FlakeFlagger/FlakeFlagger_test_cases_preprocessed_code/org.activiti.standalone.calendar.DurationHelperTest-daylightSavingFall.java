@Test public void daylightSavingFall() throws Exception {
assertEquals(parseCalendar("20131103-05:45:00",TimeZone.getTimeZone("UTC")),dh.getCalendarAfter(testingClock.getCurrentCalendar(TimeZone.getTimeZone("US/Eastern"))));
assertEquals(parseCalendar("20131103-06:45:00",TimeZone.getTimeZone("UTC")),dh.getCalendarAfter(testingClock.getCurrentCalendar(TimeZone.getTimeZone("US/Eastern"))));
}