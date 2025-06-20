@Test public void shouldNotProvideProxyUriForExternalResources() throws IOException {
assertEquals(readJsonFile("wroModel_external.json"),outputStream.toString());
}