public void testSameMessageNameFails(){
fail("exception expected");
assertTrue(e.getMessage().contains("there already is a message event subscription for the message with name"));
}