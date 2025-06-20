@Test public void testParameters(){
Assert.assertNotNull(message.getParams());
Assert.assertTrue(params == message.getParams());
}