@Test @SuppressWarnings("unchecked") public void sitePreferenceHandlerInterceptorRegistered() throws Exception {
if (o instanceof SitePreferenceHandlerInterceptor) {
}
fail("SitePreferenceHandlerInterceptor was not registered.");
}