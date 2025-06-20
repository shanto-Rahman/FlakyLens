@Test public void daylightSavingFallFirstHour() throws Exception {
assertEquals(parseCalendar("20131103-06:45:00",TimeZone.getTimeZone("UTC")),dh.getCalendarAfter(easternTime));
}