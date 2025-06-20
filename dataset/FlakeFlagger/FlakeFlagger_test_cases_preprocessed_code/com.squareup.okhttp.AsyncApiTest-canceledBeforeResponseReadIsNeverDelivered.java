@Test public void canceledBeforeResponseReadIsNeverDelivered() throws Exception {
assertEquals("/a",server.takeRequest().getPath());
assertEquals("/b",server.takeRequest().getPath());
}