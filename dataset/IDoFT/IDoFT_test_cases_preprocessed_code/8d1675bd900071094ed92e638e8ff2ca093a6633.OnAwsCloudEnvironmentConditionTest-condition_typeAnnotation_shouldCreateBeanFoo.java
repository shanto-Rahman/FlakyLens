@Test void condition_typeAnnotation_shouldCreateBeanFoo(){
assertThat(applicationContext.containsBean("foo")).isTrue();
}