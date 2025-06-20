@Test public void should_create_error_message_with_single_field_difference(){
assertThat(message).isEqualTo("[Test] \nExpecting value <\"blue\">" + " in field <\"lightSaberColor\">" + " but was <\"green\">"+ " in <Yoda the Jedi>");
}