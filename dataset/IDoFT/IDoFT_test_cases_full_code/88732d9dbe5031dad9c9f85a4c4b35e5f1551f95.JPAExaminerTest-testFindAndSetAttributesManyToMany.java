@Test public void testFindAndSetAttributesManyToMany(){
  ExaminerJPA jpaExaminer=new ExaminerJPA();
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("User");
  sourceCode=TestDataProvider.getTestSourceCodeBeforeBody() + "@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)\n" + "@JoinTable(name = \"USERS_GROUPS\", joinColumns = {\n"+ "   @JoinColumn(name = \"USERID\", nullable = false)}, inverseJoinColumns = {\n"+ "   @JoinColumn(name = \"GROUPID\", nullable = false)})\n"+ "private Set<Group> groups;\n";
  javaSource.setSourceCode(sourceCode);
  jpaExaminer.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.MANY_TO_MANY,dependency.getDependencyType());
  assertEquals("User",dependency.getJavaSourceFrom().getName());
  assertEquals("Group",dependency.getJavaSourceTo().getName());
}
