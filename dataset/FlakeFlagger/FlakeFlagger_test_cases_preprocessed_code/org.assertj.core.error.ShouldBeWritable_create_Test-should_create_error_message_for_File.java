@Test public void should_create_error_message_for_File(){
assertThat(message).isEqualTo(format("[Test] " + SHOULD_BE_WRITABLE,file));
}