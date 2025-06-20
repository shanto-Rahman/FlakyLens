@Test public void daylightSaving23HourDay() throws Exception {
assertEquals(parseCalendar("20140310-00:00:00",TimeZone.getTimeZone("US/Eastern")),dh.getCalendarAfter(testingClock.getCurrentCalendar()));
}