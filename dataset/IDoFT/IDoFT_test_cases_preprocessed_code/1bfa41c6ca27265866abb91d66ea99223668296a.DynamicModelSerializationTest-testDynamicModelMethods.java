@Test public void testDynamicModelMethods(){
assertEquals(model.getPropertyNames(),Sets.newHashSet("baseball","football"));
assertNotNull(foo);
assertEquals(model.getPropertyNames(),Sets.newHashSet("baseball","football","baseball2"));
assertNotNull(previous);
assertNotNull(props);
assertFalse(props.isEmpty());
assertEquals(props.size(),3);
assertEquals(model.getPropertyNames(),Sets.newHashSet("baseball","football"));
assertEquals(newModel,model);
assertEquals(model.getPropertyNames(),Sets.newHashSet("soccer"));
assertEquals(model.getPropertyNames(),Sets.newHashSet("soccer"));
assertTrue(model.equals(model));
assertFalse(model.equals(null));
assertFalse(model.equals(this));
assertTrue(model.hashCode() != 0);
assertEquals(model.getProperties().size(),0);
}