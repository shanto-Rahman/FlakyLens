@Test void condition_methodAnnotation_shouldCreateBeanFoo(){
  AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigWithConditionalOnMissingAwsCloudEnvironmentAnnotatedBean.class);
  assertThat(applicationContext.containsBean("foo")).isTrue();
}
