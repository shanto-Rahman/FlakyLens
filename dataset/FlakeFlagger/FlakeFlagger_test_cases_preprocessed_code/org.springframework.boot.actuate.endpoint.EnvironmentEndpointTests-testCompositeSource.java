@SuppressWarnings("unchecked") @Test public void testCompositeSource() throws Exception {
assertEquals("bar",((Map<String,Object>)env.get("composite:one")).get("foo"));
}