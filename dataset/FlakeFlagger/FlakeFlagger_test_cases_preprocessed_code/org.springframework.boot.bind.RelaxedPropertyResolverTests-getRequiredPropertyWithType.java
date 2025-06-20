@Test public void getRequiredPropertyWithType() throws Exception {
assertThat(this.resolver.getRequiredProperty("my-integer",Integer.class),equalTo(123));
}