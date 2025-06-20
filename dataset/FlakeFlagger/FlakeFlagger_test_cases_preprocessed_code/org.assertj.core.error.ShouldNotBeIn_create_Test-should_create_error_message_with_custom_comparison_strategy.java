@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <\"Luke\">\n"+ "not to be in:\n"+ " <[\"Luke\", \"Leia\"]>\n"+ "when comparing values using 'CaseInsensitiveStringComparator'");
}