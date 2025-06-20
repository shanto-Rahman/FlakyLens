@Test public void impliedOnBeanMethod() throws Exception {
assertThat(this.context.getBeansOfType(ExampleBean.class).size(),equalTo(1));
}