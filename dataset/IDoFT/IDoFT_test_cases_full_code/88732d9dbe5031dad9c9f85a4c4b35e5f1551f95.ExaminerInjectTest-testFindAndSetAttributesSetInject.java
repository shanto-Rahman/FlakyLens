@Test public void testFindAndSetAttributesSetInject(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("MyTestClass");
  sourceCode="public abstract class MyTestClass<K, E extends SingleIdEntity<K>> implements CrudAccessor<K, E>, Serializable {\n" + "protected EntityManager entityManager;\n" + "private Class<E> entityClass;\n"+ "@Inject\n"+ "TestClass testclass;\n"+ "@Inject\n"+ "Instance<TestClass2> testclass2;\n"+ "@Inject\n"+ "Event<TestClass3> testclass3;\n"+ "@Inject\n"+ "Instance<SnapshotCollector> snapshotCollectorInstance;\n"+ "@Inject\n"+ "protected void setEntityManager(EntityManager entityManager) {\n"+ "        this.entityManager = entityManager;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.INJECT,dependency.getDependencyType());
  assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
  assertEquals("TestClass",dependency.getJavaSourceTo().getName());
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(1);
  assertEquals(DependencyType.INJECT,dependency.getDependencyType());
  assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
  assertEquals("EntityManager",dependency.getJavaSourceTo().getName());
}
