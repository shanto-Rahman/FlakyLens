protected void testPage(boolean useNewCaconfig) throws ParseException {
  loadHtmlPageItemsConfig(useNewCaconfig);
  Page page=getPageUnderTest(PAGE,DESIGN_PATH_KEY,DESIGN_PATH,PageImpl.PN_CLIENTLIBS_JS_HEAD,new String[]{"coretest.product-page-js-head"},PN_CLIENT_LIBS,new String[]{"coretest.product-page","coretest.product-page-js-head"},Page.PN_APP_RESOURCES_CLIENTLIB,"coretest.product-page.appResources",CSS_CLASS_NAMES_KEY,new String[]{"class1","class2"});
  Calendar calendar=Calendar.getInstance();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",Locale.US);
  calendar.setTime(sdf.parse("2016-01-20T10:33:36.000+0100"));
  assertEquals(page.getLastModifiedDate().getTime(),calendar.getTime());
  assertEquals("en-GB",page.getLanguage());
  assertEquals("Templated Page",page.getTitle());
  assertEquals(DESIGN_PATH,page.getDesignPath());
  assertNull(page.getStaticDesignPath());
  String[] keywordsArray=page.getKeywords();
  assertEquals(3,keywordsArray.length);
  Set<String> keywords=new HashSet<>(keywordsArray.length);
  keywords.addAll(Arrays.asList(keywordsArray));
  assertTrue(keywords.contains("one") && keywords.contains("two") && keywords.contains("three"));
  assertArrayEquals(new String[]{"coretest.product-page","coretest.product-page-js-head"},page.getClientLibCategories());
  assertArrayEquals(new String[]{"" + "coretest.product-page-js-head"},page.getClientLibCategoriesJsHead());
  assertArrayEquals(new String[]{"coretest.product-page"},page.getClientLibCategoriesJsBody());
  assertEquals("product-page",page.getTemplateName());
  testJSONExport(page,getTestExporterJSONPath(testBase,PAGE));
}
