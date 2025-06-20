@Test public void disableCache(){
assertThat(this.context.getBean(VelocityViewResolver.class).getCacheLimit(),equalTo(0));
}