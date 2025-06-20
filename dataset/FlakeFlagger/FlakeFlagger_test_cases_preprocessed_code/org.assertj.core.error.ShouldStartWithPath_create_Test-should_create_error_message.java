@Test public void should_create_error_message(){
assertThat(actualMessage).isEqualTo(String.format("[Test] " + PATH_SHOULD_START_WITH,actual,other));
}