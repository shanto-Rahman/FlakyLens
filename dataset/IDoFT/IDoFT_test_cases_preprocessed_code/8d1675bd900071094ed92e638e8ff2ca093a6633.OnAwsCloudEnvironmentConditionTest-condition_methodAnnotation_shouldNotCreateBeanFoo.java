@Test void condition_methodAnnotation_shouldNotCreateBeanFoo(){
assertThat(applicationContext.containsBean("foo")).isFalse();
}