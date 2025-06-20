@Test public void testLoadEntityClass() throws Exception {
assertFalse(entityClass.equals(TestEntity.class));
assertFalse(entity instanceof TestEntity);
assertTrue(entity.getClass().isAnnotationPresent(Entity.class));
assertTrue(entityClass == tempClassLoader.loadClass(className));
}