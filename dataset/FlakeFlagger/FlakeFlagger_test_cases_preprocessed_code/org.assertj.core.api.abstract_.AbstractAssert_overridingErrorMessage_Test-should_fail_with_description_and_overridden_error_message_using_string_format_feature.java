@Test public void should_fail_with_description_and_overridden_error_message_using_string_format_feature(){
assertEquals("[test] new error message, expected value was : '8'",err.getMessage());
}