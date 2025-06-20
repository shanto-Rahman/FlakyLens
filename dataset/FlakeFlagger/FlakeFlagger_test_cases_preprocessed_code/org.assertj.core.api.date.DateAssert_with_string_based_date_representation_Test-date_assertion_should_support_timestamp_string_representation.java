@Test public void date_assertion_should_support_timestamp_string_representation(){
assertThat(date).isEqualTo(timestampAsString);
}