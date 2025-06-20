@Test void condition_typeAnnotation_shouldNotCreateBeanFoo(){
assertThat(applicationContext.containsBean("foo")).isFalse();
}