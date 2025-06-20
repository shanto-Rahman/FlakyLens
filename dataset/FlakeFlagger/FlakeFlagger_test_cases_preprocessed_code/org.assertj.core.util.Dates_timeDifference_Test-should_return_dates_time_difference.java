@Test public void should_return_dates_time_difference() throws ParseException {
assertThat(timeDifference(date1,date2)).isEqualTo(111);
assertThat(timeDifference(date2,date1)).isEqualTo(timeDifference(date1,date2));
}