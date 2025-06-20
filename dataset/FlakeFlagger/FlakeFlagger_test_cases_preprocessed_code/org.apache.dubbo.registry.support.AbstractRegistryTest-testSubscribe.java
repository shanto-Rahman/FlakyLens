/** 
 * Test method for {@link org.apache.dubbo.registry.support.AbstractRegistry#subscribe(URL,NotifyListener)}.
 * @throws Exception
 */
@Test public void testSubscribe() throws Exception {
Assert.fail();
Assert.assertTrue(e instanceof IllegalArgumentException);
Assert.fail();
Assert.assertTrue(e instanceof IllegalArgumentException);
Assert.assertNull(abstractRegistry.getSubscribed().get(testUrl));
Assert.assertNotNull(abstractRegistry.getSubscribed().get(testUrl));
Assert.assertTrue(abstractRegistry.getSubscribed().get(testUrl).contains(listener));
}