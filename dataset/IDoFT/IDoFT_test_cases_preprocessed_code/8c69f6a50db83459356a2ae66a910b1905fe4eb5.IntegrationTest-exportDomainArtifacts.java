@Test public void exportDomainArtifacts(){
assertEquals(1,artifacts.getDomains().size());
assertEquals(FooDomain.CODE,artifacts.getDomains().get(0).getCode());
assertEquals(2,artifacts.getSteps().size());
assertTrue(artifacts.getSteps().containsKey(Steps.Cancel.Activity));
assertTrue(artifacts.getSteps().containsKey(Steps.Submit.Activity));
assertEquals(4,submitSteps.size());
assertEquals(Steps.Submit.GoodsValidationGroup,submitSteps.get(0).getTags()[0]);
assertEquals(6,artifacts.getExtensions().size());
if (IDecideStepsExt.class == extension.getExt()) {
assertEquals(1,extension.getPatterns().size());
}
if (IMultiMatchExt.class == extension.getExt()) {
assertEquals(2,extension.getPatterns().size());
}
if (IPatternOnlyExt.class == extension.getExt()) {
assertEquals(0,extension.getPartners().size());
assertEquals(1,extension.getPatterns().size());
}
if (IPartnerExt.class == extension.getExt()) {
assertEquals(0,extension.getPatterns().size());
assertEquals(1,extension.getPartners().size());
}
if (IFooExt.class == extension.getExt()) {
assertEquals(3,extension.getPatterns().size());
}
assertEquals(3,foundExtN);
assertTrue(foundPatternOnlyPattern);
assertTrue(foundPartnerOnlyPattern);
assertEquals(1,artifacts.getSpecifications().size());
assertEquals("B2C业务必须要传递partnerCode",artifacts.getSpecifications().get(0).getName());
assertEquals(1,artifacts.getSpecifications().get(0).getTags().length);
}