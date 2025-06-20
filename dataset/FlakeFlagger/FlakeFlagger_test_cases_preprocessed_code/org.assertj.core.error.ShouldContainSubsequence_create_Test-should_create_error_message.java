@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <[\"Yoda\", \"Luke\"]>\nto contain subsequence:\n <[\"Han\", \"Leia\"]>\n",message);
}