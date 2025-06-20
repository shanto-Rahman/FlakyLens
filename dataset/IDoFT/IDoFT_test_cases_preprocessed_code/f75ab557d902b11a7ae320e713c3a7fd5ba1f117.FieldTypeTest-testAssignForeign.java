@Test public void testAssignForeign() throws Exception {
assertTrue(fields.length >= 3);
assertTrue(fieldType.isForeign());
assertNull(parent.foreign);
assertNotNull(foreign);
assertEquals(id,foreign.id);
assertSame(foreign,parent.foreign);
assertNotSame(foreign,parent.foreign);
assertEquals(newId,parent.foreign.id);
}