@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting\n <\"Yoda\">\nnot to be of exact type:\n <java.io.File>\nbut was:<java.lang.String>",message);
}