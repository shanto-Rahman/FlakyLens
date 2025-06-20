@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <8>\n"+ "to be less than:\n"+ " <6> when comparing values using 'AbsValueComparator'");
}