@Test public void should_create_error_message(){
assertThat(actualMessage).isEqualTo(format("[Test] " + SHOULD_BE_CANONICAL,actual));
}