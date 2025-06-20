@Test public void testMain() throws Exception {
assertEquals(ns.length,5);
assertEquals(ns.length,6);
assertEquals(w.getPropertyValue(obj,"name"),"you name");
assertEquals(w.getPropertyValue(obj,"name"),"changed");
}