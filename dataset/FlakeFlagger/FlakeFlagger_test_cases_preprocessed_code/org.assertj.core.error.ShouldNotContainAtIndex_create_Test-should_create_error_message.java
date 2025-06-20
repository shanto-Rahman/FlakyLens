@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <[\"Yoda\", \"Luke\"]>\nnot to contain:\n <\"Luke\">\nat index <1>\n",message);
}