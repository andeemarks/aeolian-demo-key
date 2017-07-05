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
