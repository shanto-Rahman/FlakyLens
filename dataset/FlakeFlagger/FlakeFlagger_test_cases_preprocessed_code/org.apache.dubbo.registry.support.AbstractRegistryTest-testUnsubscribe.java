/** 
 * Test method for   {@link org.apache.dubbo.registry.support.AbstractRegistry#unsubscribe(URL,NotifyListener)} .
 * @throws Exception
 */
@Test public void testUnsubscribe() throws Exception {
Assert.fail();
Assert.assertTrue(e instanceof IllegalArgumentException);
Assert.fail();
Assert.assertTrue(e instanceof IllegalArgumentException);
Assert.assertNull(abstractRegistry.getSubscribed().get(testUrl));
Assert.assertNotNull(abstractRegistry.getSubscribed().get(testUrl));
Assert.assertFalse(abstractRegistry.getSubscribed().get(testUrl).contains(listener));
}