@Test public void defaultValue(){
  factory=new XmlApplicationContext(new FileSystemResource(new File(srcdir,"property-placeholder.xml")));
  conf=(Configuration)factory.getBean("simpleConfiguration");
  assertEquals(false,conf.isProductionMode());
}
