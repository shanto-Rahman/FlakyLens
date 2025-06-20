@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <[\"Yoda\", \"Han\"]>\n"+ "to contain only:\n"+ "  <[\"Luke\", \"Yoda\"]>\n"+ "elements not found:\n"+ "  <[\"Luke\"]>\n"+ "and elements not expected:\n"+ "  <[\"Han\"]>\n");
}