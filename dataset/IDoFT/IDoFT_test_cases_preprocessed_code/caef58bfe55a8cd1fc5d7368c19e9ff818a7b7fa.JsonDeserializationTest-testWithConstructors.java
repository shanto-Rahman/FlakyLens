@Test public void testWithConstructors() throws IOException {
final File actualFile=new File("target/JsonDeserializationTestWithConstructors-actual.ts");//RO
if (!expectedLine.isEmpty() || !expectedLine.trim().equals("}")) {
if (actualLines.contains(expectedLine)) {
}
}
Assert.assertEquals(0,notFoundLines.size());
}