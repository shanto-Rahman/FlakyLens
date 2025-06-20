@Test public void readMethods() throws IOException {
assertTrue(reader.readOne());
assertFalse(reader.readOne());
assertEquals(expected.toString().trim().replace("\r",""),wire2.toString().trim());
}