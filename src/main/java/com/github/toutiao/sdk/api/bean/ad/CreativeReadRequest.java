package com.github.toutiao.sdk.api.bean.ad;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.github.toutiao.sdk.api.bean.BaseModel;
import com.github.toutiao.sdk.support.utils.URIUtil;
import lombok.Data;

import java.util.List;

@Data
public class CreativeReadRequest extends BaseModel {
    Long advertiser_id;
    Long ad_id;
    List<String> fields = ImmutableList.of("creative_info");

    public String toQueryString() {
        StringBuilder builder = new StringBuilder();
        builder.append("?advertiser_id=").append(advertiser_id);
        builder.append("&ad_id=").append(ad_id);
        builder.append("&fields=").append(URIUtil.encodeURIComponent(JSON.toJSONString(fields)));
        return builder.toString();
    }
}
