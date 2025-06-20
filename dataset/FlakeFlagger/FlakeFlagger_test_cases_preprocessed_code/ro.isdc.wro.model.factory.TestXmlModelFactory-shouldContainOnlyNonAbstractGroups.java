@Test public void shouldContainOnlyNonAbstractGroups(){
assertEquals(1,model.getGroups().size());
assertEquals("nonAbstract",group.getName());
assertEquals(5,group.getResources().size());
}