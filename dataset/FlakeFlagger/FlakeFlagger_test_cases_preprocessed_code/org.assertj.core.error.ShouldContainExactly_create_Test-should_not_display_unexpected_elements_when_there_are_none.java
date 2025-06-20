@Test public void should_not_display_unexpected_elements_when_there_are_none(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <[\"Yoda\"]>\n"+ "to contain exactly (and in same order):\n"+ "  <[\"Luke\", \"Yoda\"]>\n"+ "but could not find the following elements:\n"+ "  <[\"Luke\"]>\n");
}