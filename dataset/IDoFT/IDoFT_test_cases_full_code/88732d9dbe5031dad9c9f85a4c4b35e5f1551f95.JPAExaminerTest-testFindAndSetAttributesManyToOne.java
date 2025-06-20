@Test public void testFindAndSetAttributesManyToOne(){
  ExaminerJPA jpaExaminer=new ExaminerJPA();
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("MyTestClass");
  sourceCode=TestDataProvider.getTestSourceCodeBeforeBody() + "@ManyToOne(cascade = { CascadeType.DETACH })\n" + "@JoinColumn(name = \"ALBUMID\", nullable = false)\n"+ "@NotNull(groups = PersistenceConstraint.class)\n"+ "private Album album;\n";
  javaSource.setSourceCode(sourceCode);
  jpaExaminer.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.MANY_TO_ONE,dependency.getDependencyType());
  assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
  assertEquals("Album",dependency.getJavaSourceTo().getName());
}
