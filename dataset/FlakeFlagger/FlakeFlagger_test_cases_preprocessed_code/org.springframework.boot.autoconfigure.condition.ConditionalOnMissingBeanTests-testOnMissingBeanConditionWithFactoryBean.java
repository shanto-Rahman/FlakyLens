@Test public void testOnMissingBeanConditionWithFactoryBean(){
assertThat(this.context.getBean(ExampleBean.class).toString(),equalTo("fromFactory"));
}