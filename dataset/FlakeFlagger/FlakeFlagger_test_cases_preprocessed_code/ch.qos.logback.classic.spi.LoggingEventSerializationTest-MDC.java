@Test public void MDC() throws Exception {
assertEquals("testValue",MDCPropertyMap.get("key"));
}