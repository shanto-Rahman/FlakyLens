@Test public void testFindAndSetAttributesProduces(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("DatabaseProducer");
  sourceCode="package org.agoncal.application.petstore.util;\n" + "import javax.enterprise.inject.Produces;\n" + "import javax.persistence.EntityManager;\n"+ "import javax.persistence.PersistenceContext;\n"+ "public class DatabaseProducer {\n"+ "@Produces\n"+ "    @PersistenceContext(unitName = \"applicationPetstorePU\")\n"+ "    private EntityManager em;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.PRODUCES,dependency.getDependencyType());
  assertEquals("DatabaseProducer",dependency.getJavaSourceFrom().getName());
  assertEquals("EntityManager",dependency.getJavaSourceTo().getName());
}
