@Test void testGetCategoriesWithInjectedResourceTypesAndInheritance(){
  Map<String,Object> attributes=new HashMap<>();
  attributes.put("resourceTypes",new HashSet<String>(){
{
      add("core/wcm/components/accordion/v1/accordion");
      add("core/wcm/components/carousel/v3/carousel");
    }
  }
);
  ClientLibraries clientlibs=getClientLibrariesUnderTest(ROOT_PAGE,attributes);
  StringBuilder includes=new StringBuilder();
  includes.append(jsIncludes.get(ACCORDION_CATEGORY));
  includes.append(jsIncludes.get(CAROUSEL_CATEGORY));
  includes.append(cssIncludes.get(ACCORDION_CATEGORY));
  includes.append(cssIncludes.get(CAROUSEL_CATEGORY));
  assertEquals(includes.toString(),clientlibs.getJsAndCssIncludes());
}
