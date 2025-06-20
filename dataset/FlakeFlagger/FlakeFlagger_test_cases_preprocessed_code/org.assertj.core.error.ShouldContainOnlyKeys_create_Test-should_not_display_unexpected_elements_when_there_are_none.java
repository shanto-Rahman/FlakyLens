@Test public void should_not_display_unexpected_elements_when_there_are_none(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <{\"color\"=\"green\"}>\n"+ "to contain only following keys:\n"+ "  <[\"jedi\", \"color\"]>\n"+ "but could not find the following keys:\n"+ "  <[\"jedi\"]>\n");
}