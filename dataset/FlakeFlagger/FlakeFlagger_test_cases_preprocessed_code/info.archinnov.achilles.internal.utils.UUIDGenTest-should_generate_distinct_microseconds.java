@Test public void should_generate_distinct_microseconds() throws Exception {
assertThat(newTimestampInMicros).isGreaterThan(timestampInMicros);
}