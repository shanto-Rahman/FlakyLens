@Test public void testPropertyWithEnum() throws Exception {
assertThat(this.context.getBean(PropertyWithEnum.class).getValue(),equalTo(FooEnum.FOO));//RW
}