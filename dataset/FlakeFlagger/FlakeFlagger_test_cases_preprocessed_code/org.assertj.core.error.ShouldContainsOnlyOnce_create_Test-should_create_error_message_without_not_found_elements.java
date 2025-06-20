@Test public void should_create_error_message_without_not_found_elements(){
assertEquals("[Test] \nExpecting:\n" + " <[\"Yoda\", \"Han\", \"Han\"]>\n" + "to contain only once:\n"+ " <[\"Yoda\"]>\n"+ "but some elements were found more than once:\n"+ " <[\"Han\"]>\n",message);
}