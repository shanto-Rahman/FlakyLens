@Test public void shouldGenerateModelAsJson() throws Exception {
assertEquals(readJsonFile("wroModel_simple.json"),outputStream.toString());
}