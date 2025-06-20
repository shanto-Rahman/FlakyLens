@Test public void testEnabledMBeanExport(){
assertNotNull(this.context.getBean(MBeanExporter.class));
}