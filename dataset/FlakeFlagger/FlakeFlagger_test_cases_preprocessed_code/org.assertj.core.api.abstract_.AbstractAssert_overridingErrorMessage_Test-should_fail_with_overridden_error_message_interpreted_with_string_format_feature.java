@Test public void should_fail_with_overridden_error_message_interpreted_with_string_format_feature(){
assertEquals("new error message, expected value was : '8'",err.getMessage());
}