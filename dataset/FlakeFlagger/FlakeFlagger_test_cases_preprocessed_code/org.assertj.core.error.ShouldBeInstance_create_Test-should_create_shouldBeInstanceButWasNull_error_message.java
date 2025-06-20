@Test public void should_create_shouldBeInstanceButWasNull_error_message(){
assertEquals("[Test] \nExpecting object:\n \"other\"\nto be an instance of:\n <java.io.File>\nbut was null",message);
}