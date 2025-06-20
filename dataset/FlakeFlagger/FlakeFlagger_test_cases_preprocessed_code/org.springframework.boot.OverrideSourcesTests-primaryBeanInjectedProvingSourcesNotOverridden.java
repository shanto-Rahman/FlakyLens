@Test public void primaryBeanInjectedProvingSourcesNotOverridden(){
assertEquals("bar",context.getBean(Service.class).bean.name);
}