@Test public void testFindAndSetAttributesResourceInstance(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("ResourceCollector");
  sourceCode="@SnapshotDataCollector\n" + "public class ResourceCollector extends AbstractRestDataCollector<List<ConnectionPool>> {\n" + "    private static final String RESOURCES = \"resources\";\n"+ "    @Inject\n"+ "    @ResourceDataCollector\n"+ "    Instance<SpecificResourceCollector> specificCollector;\n"+ "    @Inject\n"+ "    Instance<Boolean> parallelDataCollection;\n"+ "    @Resource\n"+ "    TimerService timerService;\n"+ "    @Inject\n"+ "    ParallelDataCollectionExecutor parallelExecutor;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.RESOURCE,dependency.getDependencyType());
  assertEquals("ResourceCollector",dependency.getJavaSourceFrom().getName());
  assertEquals("TimerService",dependency.getJavaSourceTo().getName());
}
