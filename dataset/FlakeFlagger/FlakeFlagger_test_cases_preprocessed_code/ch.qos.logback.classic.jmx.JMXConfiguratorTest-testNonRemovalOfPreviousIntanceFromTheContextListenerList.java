@Test public void testNonRemovalOfPreviousIntanceFromTheContextListenerList(){
assertTrue(listenerList.contains(jmxConfigurator0));
assertEquals(1,listenerList.size());
assertTrue("old configurator should be present",listenerList.contains(jmxConfigurator0));
assertFalse("new configurator should be absent",listenerList.contains(jmxConfigurator1));
}