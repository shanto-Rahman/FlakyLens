@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + " <[\"Yoda\"]>\n"+ "not to contain\n"+ " <[\"Luke\", \"Yoda\"]>\n"+ "but found\n"+ " <[\"Yoda\"]>\n");
}