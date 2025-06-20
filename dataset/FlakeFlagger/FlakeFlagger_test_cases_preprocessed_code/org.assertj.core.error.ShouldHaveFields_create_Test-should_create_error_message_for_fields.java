@Test public void should_create_error_message_for_fields(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + "  <org.assertj.core.test.Person>\n"+ "to have fields:\n"+ "  <[\"name\", \"address\"]>\n"+ "but it doesn't have:\n"+ "  <[\"address\"]>");
}