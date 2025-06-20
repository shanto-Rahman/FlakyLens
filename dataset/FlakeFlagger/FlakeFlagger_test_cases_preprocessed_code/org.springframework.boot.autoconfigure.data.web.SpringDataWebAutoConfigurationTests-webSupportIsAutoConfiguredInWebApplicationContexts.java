@Test public void webSupportIsAutoConfiguredInWebApplicationContexts(){
assertThat(beans.size(),is(equalTo(1)));
}