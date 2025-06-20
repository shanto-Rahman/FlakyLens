/** 
 * test subscribe and unsubscribe
 */
@Test public void testSubscribeAndUnsubscribe() throws Exception {
Assert.assertThat(true,Matchers.equalTo(subscribeListeners.contains(listener)));
Assert.assertThat(false,Matchers.equalTo(unsubscribeListeners.contains(listener)));
}