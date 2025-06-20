@Test public void beanInjectedToMainConfiguration(){
assertEquals("foo",context.getBean(Service.class).bean.name);
}