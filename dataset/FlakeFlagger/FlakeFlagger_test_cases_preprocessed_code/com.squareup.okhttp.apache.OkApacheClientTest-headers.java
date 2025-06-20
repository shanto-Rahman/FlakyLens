@Test public void headers() throws Exception {
assertEquals(1,headers1.length);
assertEquals("Bar",headers1[0].getValue());
assertEquals(2,headers2.length);
assertEquals("Bar",headers2[0].getValue());
assertEquals("Baz",headers2[1].getValue());
}