@Test public void testIsInjvmRefer() throws Exception {
assertTrue(InjvmProtocol.getInjvmProtocol().isInjvmRefer(url));
assertTrue(InjvmProtocol.getInjvmProtocol().isInjvmRefer(url));
assertTrue(InjvmProtocol.getInjvmProtocol().isInjvmRefer(url));
assertTrue(InjvmProtocol.getInjvmProtocol().isInjvmRefer(url));
assertFalse(InjvmProtocol.getInjvmProtocol().isInjvmRefer(url));
assertFalse(InjvmProtocol.getInjvmProtocol().isInjvmRefer(url));
}