package com.xcz.recommendation.action;

import com.xcz.common.BaseAction;
import com.xcz.recommendation.service.recommendService;

/**
 * Created by root on 16-10-15.
 */
public class RecommendAction extends BaseAction {
    private recommendService service;

    public recommendService getService() {
        return service;
    }

    public void setService(recommendService service) {
        this.service = service;
    }


}
