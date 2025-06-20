@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertEquals("[Test] \nExpecting:\n <[\"Yoda\"]>\nto contain:\n <[\"Luke\", \"Yoda\"]>\nbut could not find:\n" + " <[\"Luke\"]>\nwhen comparing values using 'CaseInsensitiveStringComparator'",message);
}