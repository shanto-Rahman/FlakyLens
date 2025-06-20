@Test public void testMultipleOwnersBindingReferences() throws Exception {
fail("Should have thrown name not found");
assertFalse(fooDuBindingReferences.contains(serviceName));
assertFalse(barDuBindingReferences.contains(serviceName));
assertTrue(fooDuBindingReferences.contains(serviceName));
assertFalse(barDuBindingReferences.contains(serviceName));
assertTrue(fooDuBindingReferences.contains(serviceName));
assertTrue(barDuBindingReferences.contains(serviceName));
}