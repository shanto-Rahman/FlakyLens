@Test public void testOnMissingBeanConditionWithNonspecificFactoryBean(){
assertThat(this.context.getBean(ExampleBean.class).toString(),equalTo("fromFactory"));
}