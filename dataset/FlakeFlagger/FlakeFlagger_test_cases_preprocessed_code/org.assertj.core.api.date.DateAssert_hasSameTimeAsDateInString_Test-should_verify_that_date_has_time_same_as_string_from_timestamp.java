@Test public void should_verify_that_date_has_time_same_as_string_from_timestamp(){
assertThat(date).withDateFormat("yyyy-MM-dd HH:mm:ss.SSS").hasSameTimeAs(timestamp.toString());
}