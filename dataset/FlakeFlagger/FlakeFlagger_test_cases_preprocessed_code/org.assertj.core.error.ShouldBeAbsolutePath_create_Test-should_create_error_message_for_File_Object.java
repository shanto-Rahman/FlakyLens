@Test public void should_create_error_message_for_File_Object(){
assertThat(actualMessage).isEqualTo(format("[Test] " + SHOULD_BE_ABSOLUTE_PATH,file));
}