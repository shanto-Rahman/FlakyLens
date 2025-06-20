@Test public void testThrows() throws Exception {
assertNotNull(output.list());
assertEquals(2,javaFiles.size());
if (!f.getName().endsWith("Impl.java")) {
assertTrue(Files.readAllLines(f.toPath()).contains("     * @throws IOException if something going wrong"));
}
assertEquals(2,cc.getServiceClassNames().size());
assertArrayEquals(entry.getValue(),m.getExceptionTypes());
}