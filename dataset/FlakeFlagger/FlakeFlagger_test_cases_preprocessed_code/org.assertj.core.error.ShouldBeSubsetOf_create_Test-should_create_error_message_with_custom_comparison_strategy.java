@Test public void should_create_error_message_with_custom_comparison_strategy(){
assertThat(message).isEqualTo("[Test] \nExpecting when comparing values using 'CaseInsensitiveStringComparator':\n <[\"Yoda\", \"Luke\"]>\nto be subset of\n <[\"Han\", \"Luke\"]>\nbut found these extra elements:\n <[\"Yoda\"]>");
}