@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertEquals("[Test] \nExpecting:\n <[\"Yoda\", \"Luke\"]>\nnot to contain:\n <\"Luke\">\n" + "at index <1>\n" + "when comparing values using 'CaseInsensitiveStringComparator'",message);
}