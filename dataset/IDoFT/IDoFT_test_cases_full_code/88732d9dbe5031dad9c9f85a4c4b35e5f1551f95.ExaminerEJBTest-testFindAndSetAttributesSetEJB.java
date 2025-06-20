@Test public void testFindAndSetAttributesSetEJB(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("MyTestClass");
  sourceCode="public abstract class MyTestClass<K, E extends SingleIdEntity<K>> implements CrudAccessor<K, E>, Serializable {\n" + "protected EntityManager entityManager;\n" + "private Class<E> entityClass;\n"+ "@EJB\n"+ "protected void setEntityManager(EntityManager entityManager) {\n"+ "        this.entityManager = entityManager;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.EJB,dependency.getDependencyType());
  assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
  assertEquals("EntityManager",dependency.getJavaSourceTo().getName());
}
