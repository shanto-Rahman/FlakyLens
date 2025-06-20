@Test public void testOnMissingBeanConditionWithFactoryBeanInXml(){
assertThat(this.context.getBean(ExampleBean.class).toString(),equalTo("fromFactory"));
}