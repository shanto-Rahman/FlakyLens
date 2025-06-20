@Test public void getOrAddChannelTest01(){
Assert.assertNull(channel.getAttribute(CHANNEL_KEY));
Assert.assertNotNull(ret);
Assert.assertNotNull(channel.getAttribute(CHANNEL_KEY));
Assert.assertEquals(channel.getAttribute(CHANNEL_KEY).getClass(),HeaderExchangeChannel.class);
}