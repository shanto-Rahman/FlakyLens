@Test public void updatedMDC() throws Exception {
assertEquals("updatedTestValue",MDCPropertyMap.get("key"));
}