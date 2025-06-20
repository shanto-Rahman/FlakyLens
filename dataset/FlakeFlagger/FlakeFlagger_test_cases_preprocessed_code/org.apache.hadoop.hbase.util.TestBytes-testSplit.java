public void testSplit() throws Exception {
assertEquals(3,parts.length);
assertTrue(Bytes.equals(parts[1],middle));
assertEquals(4,parts.length);
assertTrue(Bytes.equals(parts[2],middle));
}