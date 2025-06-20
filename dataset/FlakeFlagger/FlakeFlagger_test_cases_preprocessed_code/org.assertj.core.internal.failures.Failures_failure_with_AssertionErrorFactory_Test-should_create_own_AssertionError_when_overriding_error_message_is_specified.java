@Test public void should_create_own_AssertionError_when_overriding_error_message_is_specified(){
assertEquals("my message",failure.getMessage());
}