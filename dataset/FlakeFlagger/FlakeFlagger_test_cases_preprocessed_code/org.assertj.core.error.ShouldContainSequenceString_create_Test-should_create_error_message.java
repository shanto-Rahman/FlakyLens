@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"" + actual + "\">\n"+ "to contain the following CharSequences in this order:\n"+ " <[\"{\", \"author\", \"title\", \"}\"]>\n"+ "but <\"title\"> was found before <\"author\">\n",message);
}