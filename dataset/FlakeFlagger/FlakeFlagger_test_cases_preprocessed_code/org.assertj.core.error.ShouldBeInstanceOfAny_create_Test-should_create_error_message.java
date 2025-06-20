@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto be an instance of any of:\n <[java.io.File, java.util.regex.Pattern]>\nbut was instance of:\n <java.lang.String>",message);
}