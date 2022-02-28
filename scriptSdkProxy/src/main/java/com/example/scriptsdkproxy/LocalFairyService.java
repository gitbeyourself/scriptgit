package com.example.scriptsdkproxy;


import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairy2;
import com.script.opencvapi.AtFairyService;

public class LocalFairyService extends AtFairyService {
    @Override
    protected void onYpFairyCreated(AtFairy2 ATFairy2) {
        if(ATFairy2 instanceof AtFairyImpl) {
            ScriptSdkProxy.init((AtFairyImpl) ATFairy2);
        }
    }

}
