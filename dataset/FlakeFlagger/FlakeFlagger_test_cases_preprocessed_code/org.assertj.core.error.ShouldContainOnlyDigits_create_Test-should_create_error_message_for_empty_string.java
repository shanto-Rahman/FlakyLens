@Test public void should_create_error_message_for_empty_string(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <\"\">\n"+ "to contain only digits\n"+ "but could not found any digits at all");
}