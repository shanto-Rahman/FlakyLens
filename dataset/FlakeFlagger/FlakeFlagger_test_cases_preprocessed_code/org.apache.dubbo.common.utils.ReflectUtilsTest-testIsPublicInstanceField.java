@Test public void testIsPublicInstanceField() throws Exception {
assertTrue(ReflectUtils.isPublicInstanceField(field));
assertFalse(ReflectUtils.isPublicInstanceField(field));
}