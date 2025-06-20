@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <8>\n"+ "to be less than:\n"+ " <6> ");
}