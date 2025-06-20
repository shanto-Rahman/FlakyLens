@Test public void testLocalProtocol() throws Exception {
assertTrue(invoker.isAvailable());
assertEquals(service.getSize(new String[]{"","",""}),3);
assertFalse(injvmInvoker.isAvailable());
}