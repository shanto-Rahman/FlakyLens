@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Leia\">\nat index <1> but found:\n <\"Luke\">\nin:\n <[\"Yoda\", \"Luke\"]>\n",message);
}