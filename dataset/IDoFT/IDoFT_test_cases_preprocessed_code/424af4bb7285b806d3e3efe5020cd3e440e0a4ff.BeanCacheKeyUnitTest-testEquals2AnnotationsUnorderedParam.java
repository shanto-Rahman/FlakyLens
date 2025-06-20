@Test public void testEquals2AnnotationsUnorderedParam(){
BeanCacheKey a=new BeanCacheKey(true,String.class,null,it -> null,a12);//RW
BeanCacheKey b=new BeanCacheKey(true,String.class,null,it -> null,a21);//RW
Assert.assertEquals(a,b);
Assert.assertEquals(a.hashCode(),b.hashCode());
}