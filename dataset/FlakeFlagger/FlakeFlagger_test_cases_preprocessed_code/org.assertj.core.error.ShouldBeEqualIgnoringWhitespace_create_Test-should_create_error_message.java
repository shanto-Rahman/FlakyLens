@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <\" my\tfoo bar \">\n"+ "to be equal to:\n"+ "  <\" myfoo bar \">\n"+ "ignoring whitespace differences");
}