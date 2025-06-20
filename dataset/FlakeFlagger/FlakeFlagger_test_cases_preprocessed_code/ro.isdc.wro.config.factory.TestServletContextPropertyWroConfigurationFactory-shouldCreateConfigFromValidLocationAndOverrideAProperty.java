@Test public void shouldCreateConfigFromValidLocationAndOverrideAProperty() throws Exception {
Assert.assertEquals(connectionTimeout,victim.create().getConnectionTimeout());
}