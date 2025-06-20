@Test public void should_create_error_message_with_multiple_keys(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <{\"name\"=\"Yoda\", \"color\"=\"green\"}>\n"+ "not to contain keys:\n"+ "  <[\"name\", \"color\"]>");
}