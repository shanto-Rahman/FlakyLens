@Test public void should_create_error_message_with_all_fields_differences(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting values:\n" + "  <[\"Yoda\", \"green\"]>\n"+ "in fields:\n"+ "  <[\"name\", \"lightSaberColor\"]>\n"+ "but were:\n"+ "  <[\"Yoda\", \"blue\"]>\n"+ "in <Yoda the Jedi>.\n"+ "Comparison was performed on all fields but <[\"someIgnoredField\"]>");
}