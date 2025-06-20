@Test public void should_create_error_message_with_single_field_difference(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting value <\"green\"> in field <\"lightSaberColor\"> " + "but was <\"blue\"> in <Yoda the Jedi>.\n"+ "Comparison was performed on all fields but <[\"someIgnoredField\"]>");
}