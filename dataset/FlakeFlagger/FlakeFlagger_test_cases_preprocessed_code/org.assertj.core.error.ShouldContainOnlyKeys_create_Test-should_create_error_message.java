@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <{\"name\"=\"Yoda\", \"color\"=\"green\"}>\n"+ "to contain only following keys:\n"+ "  <[\"jedi\", \"color\"]>\n"+ "keys not found:\n"+ "  <[\"jedi\"]>\n"+ "and keys not expected:\n"+ "  <[\"name\"]>\n");
}