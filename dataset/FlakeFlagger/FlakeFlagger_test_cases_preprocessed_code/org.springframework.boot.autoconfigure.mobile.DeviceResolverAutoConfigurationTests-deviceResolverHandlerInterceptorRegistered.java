@Test @SuppressWarnings("unchecked") public void deviceResolverHandlerInterceptorRegistered() throws Exception {
if (o instanceof DeviceResolverHandlerInterceptor) {
}
fail("DeviceResolverHandlerInterceptor was not registered.");
}