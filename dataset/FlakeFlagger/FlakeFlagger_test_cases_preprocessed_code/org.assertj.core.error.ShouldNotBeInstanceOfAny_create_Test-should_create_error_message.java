@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nnot to be an instance of any of these types:\n <[java.lang.String, java.lang.Object]>",message);
}