@Test public void should_create_error_message(){
assertEquals("[Test] \nFound duplicate(s):\n <[\"Yoda\"]>\nin:\n <[\"Yoda\", \"Yoda\", \"Luke\"]>\n",message);
}