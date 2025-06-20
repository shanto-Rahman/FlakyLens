@Test public void daylightSaving23HourDayEurope() throws Exception {
assertEquals(parseCalendar("20140331-00:00:00",TimeZone.getTimeZone("Europe/Amsterdam")),dh.getCalendarAfter(testingClock.getCurrentCalendar()));
}