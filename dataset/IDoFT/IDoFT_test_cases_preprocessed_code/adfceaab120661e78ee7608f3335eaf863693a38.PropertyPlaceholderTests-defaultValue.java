@Test public void defaultValue(){
factory=new XmlApplicationContext(new FileSystemResource(new File(srcdir,"property-placeholder.xml")));
assertEquals(false,conf.isProductionMode());
}