@Test public void getComponent() throws Exception {
assertNull(components.getComponent("notexist"));
assertNull(rootComponent.getName());
assertEquals("",rootComponent.getComponentPath());
assertSame(components.getParentWebxConfiguration(),rootComponent.getWebxConfiguration());
assertSame(components.getParentApplicationContext(),rootComponent.getApplicationContext());
assertSame(components,rootComponent.getWebxComponents());
assertEquals(components.toString(),rootComponent.toString());
fail();
assertThat(e,exception("RootComponent.getWebxController()"));
}