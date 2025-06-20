@Test public void setsUniqueNameIfNull() throws Exception {
assertThat(this.bean.getUniqueName(),equalTo("beanName"));
}