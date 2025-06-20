@Test public void should_create_error_message() throws Exception {
assertThat(errorMessage).isEqualTo(format("[TEST] %n" + "Expecting actual's toString() to return:%n" + "  <\"java\">%n"+ "but was:%n"+ "  <\"c++\">"));
}