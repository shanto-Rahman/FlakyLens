public void testMockResponseSetHeader(){
assertEquals(Arrays.asList("Cookies: delicious","cookie: r=robot"),response.getHeaders());
}