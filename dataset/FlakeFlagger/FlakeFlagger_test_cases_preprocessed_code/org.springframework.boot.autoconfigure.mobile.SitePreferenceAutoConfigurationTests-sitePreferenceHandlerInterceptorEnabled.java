@Test public void sitePreferenceHandlerInterceptorEnabled() throws Exception {
assertNotNull(this.context.getBean(SitePreferenceHandlerInterceptor.class));
}