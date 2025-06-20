@Test public void testMultigetCount(){
if (j % 2 == 0) {
}
assertEquals(5,counts.size());
assertEquals(new Integer(25),counts.entrySet().iterator().next().getValue());
assertEquals(5,counts.size());
assertEquals(new Integer(5),counts.entrySet().iterator().next().getValue());
}