@Test public void shouldSupportAbstractGroup(){
assertNotNull(model);
assertEquals(1,model.getGroups().size());
assertEquals("nonAbstractGroup",group.getName());
assertEquals(1,group.getResources().size());
}