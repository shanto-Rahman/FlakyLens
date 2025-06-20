@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto be an instance of:\n <java.io.File>\nbut was instance of:\n <java.lang.String>",message);
}