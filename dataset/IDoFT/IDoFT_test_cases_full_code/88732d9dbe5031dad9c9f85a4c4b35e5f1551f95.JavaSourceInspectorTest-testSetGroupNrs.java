@Test public void testSetGroupNrs(){
  JavaSourceContainer.getInstance().clear();
  JavaSource javaSource1=JavaSourceFactory.getInstance().newJavaSource("JavaSource1");
  javaSource1.setName("TestClass1");
  javaSource1.setPackagePath("package de.strullerbaumann.visualee.test.1;");
  JavaSourceContainer.getInstance().add(javaSource1);
  JavaSource javaSource2=JavaSourceFactory.getInstance().newJavaSource("JavaSource2");
  javaSource2.setName("TestClass2");
  javaSource2.setPackagePath("package de.strullerbaumann.visualee.test.2;");
  JavaSourceContainer.getInstance().add(javaSource2);
  JavaSource javaSource3=JavaSourceFactory.getInstance().newJavaSource("JavaSource3");
  javaSource3.setName("TestClass3");
  javaSource3.setPackagePath("package de.strullerbaumann.visualee.test.1;");
  JavaSourceContainer.getInstance().add(javaSource3);
  JavaSourceInspector.getInstance().setGroupNrs();
  assertEquals(1,javaSource1.getGroup());
  assertEquals(javaSource1.getGroup(),javaSource3.getGroup());
  assertEquals(2,javaSource2.getGroup());
}
