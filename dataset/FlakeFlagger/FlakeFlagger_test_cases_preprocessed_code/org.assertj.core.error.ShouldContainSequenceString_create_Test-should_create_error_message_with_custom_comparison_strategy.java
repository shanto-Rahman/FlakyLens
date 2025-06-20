@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertEquals("[Test] \nExpecting:\n <\"" + actual + "\">\n"+ "to contain the following CharSequences in this order:\n"+ " <[\"{\", \"author\", \"title\", \"}\"]>\n"+ "but <\"title\"> was found before <\"author\">\n"+ "when comparing values using 'CaseInsensitiveStringComparator'",message);
}