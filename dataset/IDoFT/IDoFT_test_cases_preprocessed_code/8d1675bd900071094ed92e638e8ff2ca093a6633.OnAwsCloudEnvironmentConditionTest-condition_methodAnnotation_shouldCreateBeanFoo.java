@Test void condition_methodAnnotation_shouldCreateBeanFoo(){
assertThat(applicationContext.containsBean("foo")).isTrue();
}