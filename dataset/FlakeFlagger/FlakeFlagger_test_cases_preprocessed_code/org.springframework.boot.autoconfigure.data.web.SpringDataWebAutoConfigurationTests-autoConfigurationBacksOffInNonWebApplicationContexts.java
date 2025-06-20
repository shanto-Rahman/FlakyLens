@Test public void autoConfigurationBacksOffInNonWebApplicationContexts(){
assertThat(beans.size(),is(equalTo(0)));
}