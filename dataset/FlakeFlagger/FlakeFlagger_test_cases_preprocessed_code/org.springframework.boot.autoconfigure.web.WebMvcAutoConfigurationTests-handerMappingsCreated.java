@Test public void handerMappingsCreated() throws Exception {
assertEquals(6,this.context.getBeanNamesForType(HandlerMapping.class).length);
}