@Test public void failedRoutesAreLast() throws Exception {
assertTrue(regularRoutes.size() > 1);
assertEquals(regularRoutes.get(0).getRoute(),routesWithFailedRoute.get(routesWithFailedRoute.size() - 1).getRoute());
assertEquals(regularRoutes.size(),routesWithFailedRoute.size());
}