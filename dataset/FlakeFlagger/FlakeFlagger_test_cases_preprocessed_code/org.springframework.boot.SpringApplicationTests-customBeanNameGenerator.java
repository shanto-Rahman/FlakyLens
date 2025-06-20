@Test public void customBeanNameGenerator() throws Exception {
assertThat(this.context.getBean(AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR),sameInstance((Object)beanNameGenerator));
}