@Test public void bindUnbindBind() throws Exception {
assertNull(getBinderServiceFor(name));
assertTrue(registry.bind(name,obj));
assertNotNull(getBinderServiceFor(name));
assertNull(getBinderServiceFor(name));
assertTrue(registry.bind(name,obj));
assertNotNull(getBinderServiceFor(name));
}