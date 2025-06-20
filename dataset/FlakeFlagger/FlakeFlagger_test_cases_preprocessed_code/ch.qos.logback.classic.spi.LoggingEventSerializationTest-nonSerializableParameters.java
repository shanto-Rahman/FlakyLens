@Test public void nonSerializableParameters() throws Exception {
assertNotNull(aa);
assertEquals(2,aa.length);
assertEquals("LC(0)",aa[0]);
assertNull(aa[1]);
}