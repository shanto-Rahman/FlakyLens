@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting:\n" + "  <{\"name\"=\"Yoda\", \"color\"=\"green\"}>\n"+ "to contain value:\n"+ "  <\"VeryOld\">");
}