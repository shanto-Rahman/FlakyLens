@Test public void testIsBeanPropertyReadMethod() throws Exception {
assertTrue(ReflectUtils.isBeanPropertyReadMethod(method));
assertFalse(ReflectUtils.isBeanPropertyReadMethod(method));
assertFalse(ReflectUtils.isBeanPropertyReadMethod(method));
assertFalse(ReflectUtils.isBeanPropertyReadMethod(method));
}