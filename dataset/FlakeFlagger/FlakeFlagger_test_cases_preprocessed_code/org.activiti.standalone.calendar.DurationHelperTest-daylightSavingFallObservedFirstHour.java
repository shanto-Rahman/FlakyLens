@Test public void daylightSavingFallObservedFirstHour() throws Exception {
assertTrue(expected.compareTo(dh.getCalendarAfter()) == 0);
}