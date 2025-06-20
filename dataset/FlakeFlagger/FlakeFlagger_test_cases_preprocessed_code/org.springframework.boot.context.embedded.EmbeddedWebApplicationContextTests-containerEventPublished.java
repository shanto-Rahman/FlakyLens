@Test public void containerEventPublished() throws Exception {
assertNotNull(event);
assertTrue(event.getSource().getPort() >= 0);
assertEquals(this.context,event.getApplicationContext());
}