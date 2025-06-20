@Test public void should_create_error_message_for_array(){
assertThat(message).isEqualTo(String.format("[Test] %n" + "Expecting:%n" + "  <[\"Yoda\", 5L]>%n"+ "to only have elements of type:%n"+ "  <java.lang.String>%n"+ "but found:%n"+ "  <java.lang.Long>"));
}