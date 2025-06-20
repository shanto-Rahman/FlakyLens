@Test public void getComponent() throws Exception {
  assertNull(components.getComponent("notexist"));
  WebxComponent rootComponent=components.getComponent(null);
  assertNull(rootComponent.getName());
  assertEquals("",rootComponent.getComponentPath());
  assertSame(components.getParentWebxConfiguration(),rootComponent.getWebxConfiguration());
  assertSame(components.getParentApplicationContext(),rootComponent.getApplicationContext());
  assertSame(components,rootComponent.getWebxComponents());
  assertEquals(components.toString(),rootComponent.toString());
  try {
    rootComponent.getWebxController();
    fail();
  }
 catch (  UnsupportedOperationException e) {
    assertThat(e,exception("RootComponent.getWebxController()"));
  }
}
