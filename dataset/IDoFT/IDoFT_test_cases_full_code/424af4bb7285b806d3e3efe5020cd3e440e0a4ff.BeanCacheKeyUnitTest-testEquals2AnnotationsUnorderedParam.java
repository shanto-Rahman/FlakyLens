@Test public void testEquals2AnnotationsUnorderedParam(){
  BeanCacheKey a=new BeanCacheKey(true,String.class,null,it -> null,a12);
  BeanCacheKey b=new BeanCacheKey(true,String.class,null,it -> null,a21);
  Assert.assertEquals(a,b);
  Assert.assertEquals(a.hashCode(),b.hashCode());
}
