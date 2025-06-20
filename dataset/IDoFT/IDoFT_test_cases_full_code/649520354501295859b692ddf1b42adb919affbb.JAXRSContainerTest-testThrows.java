@Test public void testThrows() throws Exception {
  JAXRSContainer container=new JAXRSContainer(null);
  ToolContext context=new ToolContext();
  context.put(WadlToolConstants.CFG_OUTPUTDIR,output.getCanonicalPath());
  context.put(WadlToolConstants.CFG_WADLURL,getLocation("/wadl/test.xml"));
  context.put(WadlToolConstants.CFG_COMPILE,Boolean.TRUE);
  context.put(WadlToolConstants.CFG_INTERFACE,Boolean.TRUE);
  context.put(WadlToolConstants.CFG_IMPL,Boolean.TRUE);
  context.put(WadlToolConstants.CFG_CREATE_JAVA_DOCS,Boolean.TRUE);
  container.setContext(context);
  container.execute();
  assertNotNull(output.list());
  List<File> javaFiles=FileUtils.getFilesRecurseUsingSuffix(output,".java");
  assertEquals(2,javaFiles.size());
  for (  File f : javaFiles) {
    if (!f.getName().endsWith("Impl.java")) {
      assertTrue(Files.readAllLines(f.toPath()).contains("     * @throws IOException if something going wrong"));
    }
  }
  ClassCollector cc=context.get(ClassCollector.class);
  assertEquals(2,cc.getServiceClassNames().size());
  final Map<String,Class<?>[]> methods=new HashMap<>();
  methods.put("listRepositories",new Class<?>[]{});
  methods.put("createRepository",new Class<?>[]{java.io.IOException.class});
  methods.put("deleteRepository",new Class<?>[]{javax.ws.rs.NotFoundException.class,java.io.IOException.class});
  methods.put("postThename",new Class<?>[]{java.io.IOException.class,java.lang.NoSuchMethodException.class});
  try (URLClassLoader loader=new URLClassLoader(new URL[]{output.toURI().toURL()})){
    for (    String className : cc.getServiceClassNames().values()) {
      final Class<?> generatedClass=loader.loadClass(className);
      for (      Map.Entry<String,Class<?>[]> entry : methods.entrySet()) {
        Method m;
        try {
          m=generatedClass.getMethod(entry.getKey(),String.class);
        }
 catch (        NoSuchMethodException e) {
          m=generatedClass.getMethod(entry.getKey(),String.class,String.class);
        }
        assertArrayEquals(entry.getValue(),m.getExceptionTypes());
      }
    }
  }
 }
