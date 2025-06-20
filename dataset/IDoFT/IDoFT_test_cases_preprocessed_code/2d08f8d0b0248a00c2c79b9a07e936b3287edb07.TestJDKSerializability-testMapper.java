public void testMapper() throws IOException {
assertEquals(EXP,mapper.writeValueAsString(p));
assertEquals(EXP,mapper2.writeValueAsString(p));
assertEquals(p.x,p2.x);
assertEquals(p.y,p2.y);
}