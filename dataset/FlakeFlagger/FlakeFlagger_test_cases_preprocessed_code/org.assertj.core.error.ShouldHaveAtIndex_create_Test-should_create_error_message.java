@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <\"Luke\">\nat index <1> to have:\n <red lightsaber>\nin:\n" + " <[\"Yoda\", \"Luke\"]>\n",message);
}