@Test public void extensions_simple() throws Exception {
assertNotNull(containerDTO);
assertNotNull(containerDTO.bundle);
assertEquals(1,containerDTO.bundle.id);
assertEquals(24l,containerDTO.bundle.lastModified);
assertEquals(Bundle.ACTIVE,containerDTO.bundle.state);
assertEquals("foo",containerDTO.bundle.symbolicName);
assertEquals("1.0.0",containerDTO.bundle.version);
assertEquals(1,containerDTO.changeCount);
assertTrue(containerDTO.components + "",containerDTO.components.isEmpty());
assertTrue(containerDTO.errors + "",containerDTO.errors.isEmpty());
assertTrue(containerDTO.extensions + "",containerDTO.extensions.isEmpty());
assertNotNull(containerDTO.template);
assertEquals(2,containerDTO.template.components.size());
assertEquals(2,containerDTO.template.extensions.size());
assertEquals("(&(foo=name)(service.bundleid=1))",containerDTO.template.extensions.get(0).serviceFilter);
assertEquals("(&(fum=bar)(service.bundleid=1))",containerDTO.template.extensions.get(1).serviceFilter);
assertEquals("foo",containerDTO.template.id);
}