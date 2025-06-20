@Test public void daylightSaving25HourDayEurope() throws Exception {
assertEquals(parseCalendar("20131028-00:00:00",TimeZone.getTimeZone("Europe/Amsterdam")),dh.getCalendarAfter(testingClock.getCurrentCalendar()));
}