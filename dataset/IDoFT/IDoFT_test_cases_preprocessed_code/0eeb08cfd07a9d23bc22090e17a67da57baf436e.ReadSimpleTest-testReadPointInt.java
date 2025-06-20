public void testReadPointInt() throws Exception {
assertNotNull(bytes);
assertEquals(6,bytes.length);
assertNotNull(result);
assertEquals(input.x,result.x);
assertEquals(input.y,result.y);
assertEquals("x",p.currentName());
assertEquals(input.x,p.getIntValue());
assertEquals("y",p.currentName());
assertEquals(input.y,p.getIntValue());
}