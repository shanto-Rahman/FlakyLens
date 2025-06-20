@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nnot to have not the same class as:\n <\"Luke\"> (java.lang.String)",message);
}