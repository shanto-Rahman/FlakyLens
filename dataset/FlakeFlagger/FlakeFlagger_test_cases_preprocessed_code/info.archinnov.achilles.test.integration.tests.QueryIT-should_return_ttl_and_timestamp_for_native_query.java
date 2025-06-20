@Test public void should_return_ttl_and_timestamp_for_native_query() throws Exception {
assertThat((Integer)result.get("ttl(name)")).isLessThanOrEqualTo(1000);
assertThat(result.get("writetime(age_in_years)")).isEqualTo(timestamp);
}