@Test public void testVulnerabilitiesAvailable() throws IOException {
Optional<OwaspDependencyCheckEntry> entry=Optional.of(Json.mapper().readValue(new File(content),OwaspDependencyCheckEntry.class));//RO
assertEquals(0,values.size());
assertEquals(1,values.size());
assertTrue(values.has(VULNERABILITIES_IN_ARTIFACT));
assertTrue(values.of(VULNERABILITIES_IN_ARTIFACT).isPresent());
assertFalse(values.of(VULNERABILITIES_IN_ARTIFACT).get().isUnknown());
assertEquals(3,vulnerabilities.size());
assertEquals("CVE-2018-11307",vulnerability.id());
}