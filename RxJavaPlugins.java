public class AcrAccessAreaController extends BaseController {

    @Autowired                                                                     
    private AcrAccessAreaService acrAccessAreaService; 
    @RequestMapping("/action")
    public String action(ModelMap model, AcrAccessAreaModel acrAccessAreaModel) {

        try {
            if(acrAccessAreaModel.getTrStatus().equals(TrStatus.DELETE))
            {
                Map cateData = acrAccessAreaService.chkUseYnArea(acrAccessAreaModel);
                int cnt = Integer.parseInt(((AcrAccessAreaModel)cateData.get("chkInfo")).getCnt());

                if(cnt > 0)
                {
                    super.setResult(model,Result.E04);
                    return "/dummy"; 
                }
            }
            Map accData = acrAccessAreaService.action(acrAccessAreaModel);
            model.put("accAreaInfo",accData.get("accAreaInfo"));

            super.setResult(model);

        } catch(Exception e) {
            super.setResult(model, new ApprovalException(e));
        }
        return "/dummy"; 
    }
}

public class AcrAssociationController extends BaseController {
    @Autowired                                                                     
    private AcrAssociationService acrAssociationService; 
    @RequestMapping("/action")
    public String action(ModelMap model, AcrAssociationModel acrAssociationModel) {

        try {

            if(acrAssociationModel.getTrStatus().equals(TrStatus.DELETE))
            {
                Map assoData = acrAssociationService.chkUseYn(acrAssociationModel);
                int cnt = Integer.parseInt(((AcrAssociationModel)assoData.get("chkInfo")).getCnt());

                if(cnt > 0)
                {
                    super.setResult(model,Result.E04);
                    return "/dummy"; 
                }
            }

            Map assoData = acrAssociationService.action(acrAssociationModel);
            model.put("assoInfo",assoData.get("assoInfo"));

            super.setResult(model);

        } catch(Exception e) {
            super.setResult(model, new ApprovalException(e));
        }
        return "/dummy"; 
    }
}

public class AcrCategoryController extends BaseController {
    @Autowired                                                                     
    private AcrCategoryServiceacrCategoryService; 

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