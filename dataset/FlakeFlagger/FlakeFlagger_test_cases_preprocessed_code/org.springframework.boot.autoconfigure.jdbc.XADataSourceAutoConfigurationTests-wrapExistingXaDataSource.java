@Test public void wrapExistingXaDataSource() throws Exception {
assertThat(wrapper.getXaDataSource(),equalTo(source));//IT
}