@Test public void should_fail_if_given_date_string_representation_cant_be_parsed_with_default_date_formats(){
assertThat(new Date()).isEqualTo(dateAsString);
}