/** 
 * Tests the shaped links support for custom object drawers in the main document area and in the page margin on multiple pages.
 */
@Test public void testPR480LinkShapes() throws IOException {
  try (PDDocument doc=run("pr-480-link-shapes",TestSupport.WITH_SHAPES_DRAWER)){
    StringBuilder sb=new StringBuilder();
    List<float[]> page0=new ArrayList<>();
    List<float[]> page1=new ArrayList<>();
    boolean failure=false;
    page0.add(new float[]{486.75f,251.25f,468.0f,213.75f,486.75f,213.75f,505.5f,213.75f,486.75f,251.25f,505.5f,213.75f,496.125f,232.5f,486.75f,251.25f});
    page0.add(new float[]{449.25f,270.0f,449.25f,251.25f,458.625f,251.25f,468.0f,251.25f,449.25f,270.0f,468.0f,251.25f,468.0f,260.625f,468.0f,270.0f});
    page0.add(new float[]{505.5f,213.75f,505.5f,195.0f,514.875f,195.0f,524.25f,195.0f,505.5f,213.75f,524.25f,195.0f,524.25f,204.375f,524.25f,213.75f});
    page0.add(new float[]{243.0f,203.25f,243.0f,128.25f,280.5f,128.25f,318.0f,128.25f,243.0f,203.25f,318.0f,128.25f,318.0f,165.75f,318.0f,203.25f});
    page0.add(new float[]{168.0f,353.25f,93.0f,203.25f,168.0f,203.25f,243.0f,203.25f,168.0f,353.25f,243.0f,203.25f,205.5f,278.25f,168.0f,353.25f});
    page0.add(new float[]{18.0f,428.25f,18.0f,353.25f,55.5f,353.25f,93.0f,353.25f,18.0f,428.25f,93.0f,353.25f,93.0f,390.75f,93.0f,428.25f});
    failure|=qAssert(page0,getQuadPoints(doc,0,0),sb,0,0);
    failure|=qAssert(page0,getQuadPoints(doc,0,1),sb,0,1);
    failure|=qAssert(page0,getQuadPoints(doc,0,2),sb,0,2);
    failure|=qAssert(page0,getQuadPoints(doc,0,3),sb,0,3);
    failure|=qAssert(page0,getQuadPoints(doc,0,4),sb,0,4);
    failure|=qAssert(page0,getQuadPoints(doc,0,5),sb,0,5);
    page1.add(new float[]{486.75f,251.25f,468.0f,213.75f,486.75f,213.75f,505.5f,213.75f,486.75f,251.25f,505.5f,213.75f,496.125f,232.5f,486.75f,251.25f});
    page1.add(new float[]{449.25f,270.0f,449.25f,251.25f,458.625f,251.25f,468.0f,251.25f,449.25f,270.0f,468.0f,251.25f,468.0f,260.625f,468.0f,270.0f});
    page1.add(new float[]{505.5f,213.75f,505.5f,195.0f,514.875f,195.0f,524.25f,195.0f,505.5f,213.75f,524.25f,195.0f,524.25f,204.375f,524.25f,213.75f});
    page1.add(new float[]{243.0f,209.25f,243.0f,134.25f,280.5f,134.25f,318.0f,134.25f,243.0f,209.25f,318.0f,134.25f,318.0f,171.75f,318.0f,209.25f});
    page1.add(new float[]{168.0f,359.25f,93.0f,209.25f,168.0f,209.25f,243.0f,209.25f,168.0f,359.25f,243.0f,209.25f,205.5f,284.25f,168.0f,359.25f});
    page1.add(new float[]{18.0f,434.25f,18.0f,359.25f,55.5f,359.25f,93.0f,359.25f,18.0f,434.25f,93.0f,359.25f,93.0f,396.75f,93.0f,434.25f});
    failure|=qAssert(page1,getQuadPoints(doc,1,0),sb,1,0);
    failure|=qAssert(page1,getQuadPoints(doc,1,1),sb,1,1);
    failure|=qAssert(page1,getQuadPoints(doc,1,2),sb,1,2);
    failure|=qAssert(page1,getQuadPoints(doc,1,3),sb,1,3);
    failure|=qAssert(page1,getQuadPoints(doc,1,4),sb,1,4);
    failure|=qAssert(page1,getQuadPoints(doc,1,5),sb,1,5);
    if (failure) {
      System.out.print(sb.toString());
      Assert.fail("Quad points were not correct");
    }
    remove("pr-480-link-shapes",doc);
  }
 }
