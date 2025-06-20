@Test public void closeTest(){
Assert.assertFalse(channel.isClosed());
Assert.assertTrue(channel.isClosed());
}