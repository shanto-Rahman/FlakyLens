@Test void condition_typeAnnotation_shouldCreateBeanFoo(){
  AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigWithConditionalOnMissingAwsCloudEnvironmentAnnotation.class);
  assertThat(applicationContext.containsBean("foo")).isTrue();
}
