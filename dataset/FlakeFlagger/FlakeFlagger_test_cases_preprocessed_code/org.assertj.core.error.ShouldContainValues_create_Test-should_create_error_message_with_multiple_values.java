@Test public void should_create_error_message_with_multiple_values(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <{\"name\"=\"Yoda\", \"color\"=\"green\"}>\n"+ "to contain values:\n"+ "  <[\"VeryOld\", \"Vader\"]>");
}