@Test public void contextReset() throws Exception {
assertEquals(1,listenerList.size());
assertEquals(1,listenerList.size());
assertTrue(listenerList.contains(jmxConfigurator));
assertTrue(mbs.isRegistered(objectName));
}