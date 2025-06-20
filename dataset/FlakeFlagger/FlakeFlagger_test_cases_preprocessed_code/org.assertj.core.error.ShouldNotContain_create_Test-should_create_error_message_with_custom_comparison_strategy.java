@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + " <[\"Yoda\"]>\n"+ "not to contain\n"+ " <[\"Luke\", \"Yoda\"]>\n"+ "but found\n <[\"Yoda\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'");
}