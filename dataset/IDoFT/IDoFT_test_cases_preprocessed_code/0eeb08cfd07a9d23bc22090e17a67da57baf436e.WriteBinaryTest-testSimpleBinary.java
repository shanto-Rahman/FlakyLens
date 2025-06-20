public void testSimpleBinary() throws Exception {
assertEquals(18,bytes.length);
assertEquals(input.id,result.id);
assertEquals(input.trailer,result.trailer);
assertNotNull(result.data);
assertFalse(p.hasTextCharacters());
assertEquals(input.trailer,p.getIntValue());
assertEquals("data",p.currentName());
assertEquals(input.trailer,p.nextIntValue(-1));
}