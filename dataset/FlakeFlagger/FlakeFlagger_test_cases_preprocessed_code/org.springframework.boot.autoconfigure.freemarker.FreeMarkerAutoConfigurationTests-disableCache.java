@Test public void disableCache(){
assertThat(this.context.getBean(FreeMarkerViewResolver.class).getCacheLimit(),equalTo(0));
}