@Test public void should_create_error_message_with_all_fields_differences_without_ignored_fields(){
assertThat(message).isEqualTo("[Test] \nExpecting values:\n" + "  <[\"Yoda\", \"green\"]>\n" + "in fields:\n"+ "  <[\"name\", \"lightSaberColor\"]>\n"+ "but were:\n"+ "  <[\"Yoda\", \"blue\"]>\n"+ "in <Yoda the Jedi>.\n"+ "Comparison was performed on all fields");
}