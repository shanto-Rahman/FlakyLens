@Test void condition_methodAnnotation_shouldNotCreateBeanFoo(){
  AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigWithConditionalOnAwsCloudEnvironmentAnnotatedBean.class);
  assertThat(applicationContext.containsBean("foo")).isFalse();
}
