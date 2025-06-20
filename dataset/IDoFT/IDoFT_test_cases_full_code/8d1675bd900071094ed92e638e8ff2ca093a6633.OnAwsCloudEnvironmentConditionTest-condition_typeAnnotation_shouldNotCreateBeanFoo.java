@Test void condition_typeAnnotation_shouldNotCreateBeanFoo(){
  AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigWithConditionalOnAwsCloudEnvironmentAnnotation.class);
  assertThat(applicationContext.containsBean("foo")).isFalse();
}
