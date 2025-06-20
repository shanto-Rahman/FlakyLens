@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto be in:\n <[\"Luke\", \"Leia\"]>\nwhen comparing values using 'CaseInsensitiveStringComparator'",message);
}