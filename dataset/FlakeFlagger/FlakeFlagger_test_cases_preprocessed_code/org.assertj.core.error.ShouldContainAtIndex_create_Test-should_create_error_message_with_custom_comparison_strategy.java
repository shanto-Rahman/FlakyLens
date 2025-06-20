@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertEquals("[Test] \nExpecting:\n <\"Leia\">\nat index <1> but found:\n <\"Luke\">\nin:\n <[\"Yoda\", \"Luke\"]>\n" + "when comparing values using 'CaseInsensitiveStringComparator'",message);
}