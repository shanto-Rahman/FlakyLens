@Test public void testModuleInfo(){
assertThat(referenceBean.getModule().getName(),is("defaultModule"));
assertThat(referenceBean.getMonitor(),not(nullValue()));
}