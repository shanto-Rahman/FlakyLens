@Test public void daylightSaving25HourDay() throws Exception {
assertEquals(parseCalendar("20131104-00:00:00",TimeZone.getTimeZone("US/Eastern")),dh.getCalendarAfter(testingClock.getCurrentCalendar()));
}