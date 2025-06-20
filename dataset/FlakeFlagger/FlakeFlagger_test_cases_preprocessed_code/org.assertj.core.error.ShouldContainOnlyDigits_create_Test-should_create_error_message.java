@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <\"10$\">\n"+ "to contain only digits\n"+ "but found non-digit character <'$'> at index <2>");
}