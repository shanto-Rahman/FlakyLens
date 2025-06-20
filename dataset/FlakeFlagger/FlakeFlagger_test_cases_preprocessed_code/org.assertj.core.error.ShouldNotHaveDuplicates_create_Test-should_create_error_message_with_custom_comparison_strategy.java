@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertEquals("[Test] \nFound duplicate(s):\n <[\"Yoda\"]>\nin:\n <[\"Yoda\", \"Yoda\", \"Luke\"]>\n" + "when comparing values using 'CaseInsensitiveStringComparator'",message);
}