@Test public void invoke() throws Exception {
assertThat((String)getEndpointBean().invoke().get("message"),startsWith("Shutting down"));
assertTrue(this.context.isActive());
assertTrue(latch.await(10,TimeUnit.SECONDS));
}