@Test public void should_create_error_message_with_single_field_difference_without_ignored_fields(){
assertThat(message).isEqualTo("[Test] \nExpecting value <\"green\"> " + "in field <\"lightSaberColor\"> " + "but was <\"blue\"> in <Yoda the Jedi>.\n"+ "Comparison was performed on all fields");
}