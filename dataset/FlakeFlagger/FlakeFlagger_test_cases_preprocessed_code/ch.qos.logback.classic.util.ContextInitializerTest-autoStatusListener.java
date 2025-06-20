@Test public void autoStatusListener() throws JoranException {
assertEquals(0,statusListenerList.size());
assertTrue(statusListenerList.size() + " should be 1",statusListenerList.size() == 1);
assertTrue("expecting at least one event in list",tsl.list.size() > 0);
}