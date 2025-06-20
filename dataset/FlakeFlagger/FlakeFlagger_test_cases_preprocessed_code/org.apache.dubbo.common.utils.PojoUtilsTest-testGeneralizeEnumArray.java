@Test public void testGeneralizeEnumArray() throws Exception {
assertTrue(o instanceof String[]);
assertEquals(((String[])o)[0],"FRIDAY");
assertEquals(((String[])o)[1],"SATURDAY");
}