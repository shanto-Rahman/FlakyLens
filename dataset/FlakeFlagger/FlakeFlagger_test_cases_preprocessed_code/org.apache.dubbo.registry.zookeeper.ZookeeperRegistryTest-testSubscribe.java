@Test public void testSubscribe(){
assertThat(subscribed.size(),is(1));
assertThat(subscribed.get(serviceUrl).size(),is(1));
assertThat(subscribed.size(),is(1));
assertThat(subscribed.get(serviceUrl).size(),is(0));
}