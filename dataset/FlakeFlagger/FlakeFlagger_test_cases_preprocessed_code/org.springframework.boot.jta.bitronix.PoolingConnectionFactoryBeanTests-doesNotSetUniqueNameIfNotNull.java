@Test public void doesNotSetUniqueNameIfNotNull() throws Exception {
assertThat(this.bean.getUniqueName(),equalTo("un"));
}