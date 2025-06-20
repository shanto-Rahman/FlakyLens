@Test public void testValueBindingForDefaults() throws Exception {
assertThat(this.context.getBean(PropertyWithValue.class).getValue(),equalTo("foo"));
}