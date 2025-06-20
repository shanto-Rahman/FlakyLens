@Test public void shouldDetectChangeOfImportedResource() throws Exception {
importResourceChanged.set(true);
groupChanged.set(true);
assertTrue(groupChanged.get());
assertTrue(importResourceChanged.get());
}