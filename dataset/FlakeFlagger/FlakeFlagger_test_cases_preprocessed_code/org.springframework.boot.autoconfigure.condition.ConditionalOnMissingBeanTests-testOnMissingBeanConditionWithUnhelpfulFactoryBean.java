@Test public void testOnMissingBeanConditionWithUnhelpfulFactoryBean(){
assertThat(this.context.getBeansOfType(ExampleBean.class).values().size(),equalTo(2));
}