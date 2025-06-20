protected void testPage(boolean useNewCaconfig) throws ParseException {
assertEquals(page.getLastModifiedDate().getTime(),calendar.getTime());
assertEquals("en-GB",page.getLanguage());
assertEquals("Templated Page",page.getTitle());
assertEquals(DESIGN_PATH,page.getDesignPath());
assertNull(page.getStaticDesignPath());
assertEquals(3,keywordsArray.length);
assertTrue(keywords.contains("one") && keywords.contains("two") && keywords.contains("three"));
assertArrayEquals(new String[]{"coretest.product-page","coretest.product-page-js-head"},page.getClientLibCategories());
assertArrayEquals(new String[]{"" + "coretest.product-page-js-head"},page.getClientLibCategoriesJsHead());
assertArrayEquals(new String[]{"coretest.product-page"},page.getClientLibCategoriesJsBody());
assertEquals("product-page",page.getTemplateName());
}