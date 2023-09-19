package com.payegis.knowledge;


import com.payegis.common.*;
import com.payegis.constant.AddressParseLabelConstant;
import com.payegis.dto.Context;
import com.payegis.dto.KnowledgeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;
@Slf4j
public class MobileKnowledge {

    private static final long serialVersionUID = 3002029719998865906L;

    private static final Pattern MobilePattern = Pattern.compile("^[1-9][0-9]{10}$");


    public MobileAttribute learn(String value) {
        MobileAttribute mobileInfo = new MobileAttribute();
        if (StringUtils.isNotBlank(value) && !value.equalsIgnoreCase("NA")) {
            String mobile = value;
            Boolean isFormatValid = MobilePattern.matcher(mobile).matches();

            if (isFormatValid) {
                mobileInfo = MobileAttributeUtil.getInstance().getMobileInfo(StringUtils.left(mobile, 7));
                //log.info("MOBILE AddressCom run result :{}", mobileInfo);
                if(ObjectUtils.isEmpty(mobileInfo)){
                    return new MobileAttribute();
                }
                return mobileInfo;
            }
        }
        return mobileInfo;
    }

}