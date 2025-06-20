@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <6>\n"+ "to be greater than:\n"+ " <8> ");
}