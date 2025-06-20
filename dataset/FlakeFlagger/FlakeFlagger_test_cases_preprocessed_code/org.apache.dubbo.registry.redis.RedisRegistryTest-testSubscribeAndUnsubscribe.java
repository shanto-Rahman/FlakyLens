@Test public void testSubscribeAndUnsubscribe(){
assertThat(subscribed.size(),is(1));
assertThat(subscribed.get(serviceUrl).size(),is(1));
assertThat(subscribed.get(serviceUrl).size(),is(0));
}