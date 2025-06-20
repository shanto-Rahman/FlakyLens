@Test public void neither() throws Exception {
assertThat(context.containsBean("myBean"),equalTo(false));
}