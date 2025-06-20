@Test public void should_create_error_message_when_ignoring_case(){
assertEquals("[Test] \nExpecting:\n <\"Yoda\">\nto contain:\n <\"Luke\">\n (ignoring case)",message);
}