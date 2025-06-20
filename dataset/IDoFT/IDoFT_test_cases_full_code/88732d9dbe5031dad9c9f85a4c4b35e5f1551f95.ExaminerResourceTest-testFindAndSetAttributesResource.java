@Test public void testFindAndSetAttributesResource(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("DatabaseConnectionProducer");
  sourceCode="package de.gedoplan.buch.eedemos.cdi.producer;\n" + "import javax.annotation.Resource;\n" + "import javax.enterprise.context.ApplicationScoped;\n"+ "import javax.enterprise.inject.Produces;\n"+ "import javax.sql.DataSource;\n"+ "@ApplicationScoped\n"+ "public class DatabaseConnectionProducer\n"+ "{\n"+ "@Resource(lookup = \"jdbc/ee-demos\")\n"+ "@Produces\n"+ "private DataSource dataSource;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.RESOURCE,dependency.getDependencyType());
  assertEquals("DatabaseConnectionProducer",dependency.getJavaSourceFrom().getName());
  assertEquals("DataSource",dependency.getJavaSourceTo().getName());
}
