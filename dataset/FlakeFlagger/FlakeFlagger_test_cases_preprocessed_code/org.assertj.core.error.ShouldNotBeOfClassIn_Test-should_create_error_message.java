@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nnot to be of any type in:\n <[java.lang.Long, java.lang.String]>\nbut was of type:<java.lang.String>",message);
}