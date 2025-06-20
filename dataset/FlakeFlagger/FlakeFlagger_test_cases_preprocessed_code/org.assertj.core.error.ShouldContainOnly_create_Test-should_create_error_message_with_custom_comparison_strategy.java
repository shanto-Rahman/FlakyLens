@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <[\"Yoda\", \"Han\"]>\n"+ "to contain only:\n"+ "  <[\"Luke\", \"Yoda\"]>\n"+ "elements not found:\n"+ "  <[\"Luke\"]>\n"+ "and elements not expected:\n"+ "  <[\"Han\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'");
}