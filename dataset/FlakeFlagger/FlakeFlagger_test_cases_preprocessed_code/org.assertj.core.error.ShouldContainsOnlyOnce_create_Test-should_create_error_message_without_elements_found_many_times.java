@Test public void should_create_error_message_without_elements_found_many_times(){
assertEquals("[Test] \nExpecting:\n" + " <[\"Yoda\", \"Han\"]>\n" + "to contain only once:\n"+ " <[\"Luke\"]>\n"+ "but some elements were not found:\n"+ " <[\"Luke\"]>\n",message);
}