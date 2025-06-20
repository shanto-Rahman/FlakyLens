@Test public void testFindAndSetAttributesStaticProduces(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("LoggerProducer");
  sourceCode="package de.dasd.dasdas.utils.logging;\n" + "import javax.enterprise.inject.Produces;\n" + "import javax.enterprise.inject.spi.InjectionPoint;\n"+ "import org.apache.commons.logging.Log;\n"+ "import org.apache.commons.logging.LogFactory;\n"+ "public class LoggerProducer {\n"+ "    @Produces\n"+ "    public static Log getLogger(InjectionPoint injectionPoint) {\n"+ "        Class<?> targetClass = injectionPoint.getMember().getDeclaringClass();\n"+ "        return LogFactory.getLog(targetClass);\n"+ "    }\n"+ "    private LoggerProducer() {\n"+ "    }\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.PRODUCES,dependency.getDependencyType());
  assertEquals("LoggerProducer",dependency.getJavaSourceFrom().getName());
  assertEquals("Log",dependency.getJavaSourceTo().getName());
}
