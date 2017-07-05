public class AcrCategoryController extends BaseController {
    @Autowired                                                                     
    private AcrCategoryService acrCategoryService; 

       @RequestMapping("/action")
    public String action(ModelMap model, AcrCategoryModel acrCategoryModel) {

        try {
            if(acrCategoryModel.getTrStatus().equals(TrStatus.DELETE))
            {
                Map cateData = acrCategoryService.chkUseYn(acrCategoryModel);
                int cnt = Integer.parseInt(((AcrCategoryModel)cateData.get("chkInfo")).getCnt());

                if(cnt > 0)
                {
                    super.setResult(model,Result.E04);
                    return "/dummy"; 
                }
            }

            Map cateData = acrCategoryService.action(acrCategoryModel);
            model.put("categoryInfo",cateData.get("categoryInfo"));

            super.setResult(model);

        } catch(Exception e) {
            super.setResult(model, new ApprovalException(e));
        }
        return "/dummy"; 
    }
}