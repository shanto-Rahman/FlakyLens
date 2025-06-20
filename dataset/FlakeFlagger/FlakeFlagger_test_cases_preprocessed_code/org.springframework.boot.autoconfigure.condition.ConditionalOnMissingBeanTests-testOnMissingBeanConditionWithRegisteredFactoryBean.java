@Test public void testOnMissingBeanConditionWithRegisteredFactoryBean(){
assertThat(this.context.getBean(ExampleBean.class).toString(),equalTo("fromFactory"));
}