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
