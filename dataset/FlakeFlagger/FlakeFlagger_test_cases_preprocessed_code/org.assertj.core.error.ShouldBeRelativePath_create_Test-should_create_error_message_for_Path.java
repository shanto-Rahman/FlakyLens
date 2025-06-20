@Test public void should_create_error_message_for_Path() throws IOException {
assertThat(message).isEqualTo(format("[Test] " + SHOULD_BE_RELATIVE_PATH,path));
}