@Test public void testInitialFactory() throws Exception {
assertTrue(context instanceof NamingContext);
if (!NamingManager.hasInitialContextFactoryBuilder()) {
}
assertTrue(context instanceof NamingContext);
}