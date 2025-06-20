@Test public void should_fail_if_given_date_string_representation_cant_be_parsed_with_any_custom_date_formats(){
assertThat(date).withDateFormat("yyyy/MM/dd").isEqualTo("2003 04 26");
}