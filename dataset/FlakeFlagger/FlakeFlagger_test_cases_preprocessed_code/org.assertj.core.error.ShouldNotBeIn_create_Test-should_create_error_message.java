@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + " <\"Luke\">\n"+ "not to be in:\n"+ " <[\"Luke\", \"Leia\"]>\n");
}