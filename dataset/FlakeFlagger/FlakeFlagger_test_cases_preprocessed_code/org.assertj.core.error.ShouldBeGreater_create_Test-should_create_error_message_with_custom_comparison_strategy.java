@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <6>\n"+ "to be greater than:\n"+ " <8> when comparing values using 'AbsValueComparator'");
}