@Test public void should_create_error_message_for_iterable(){
assertThat(message).isEqualTo(String.format("[Test] %n" + "Expecting:%n" + "  <[\"Yoda\", \"Luke\"]>%n"+ "to have at least one element of type:%n"+ "  <java.lang.Long>%n"+ "but had none."));
}