package com.github.toutiao.sdk.api.bean.ad;

import com.alibaba.fastjson.JSON;
import com.github.toutiao.sdk.api.bean.BaseModel;
import com.github.toutiao.sdk.support.utils.URIUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Objects;

@Data
public class CampaignGetRequest extends BaseModel {
    private Long advertiser_id;
    private Integer page = 1;
    private Integer page_size = 10;
    private Filter filtering;

    public String toQueryString() {
        StringBuilder builder = new StringBuilder();
        builder.append("?advertiser_id=").append(advertiser_id);
        builder.append("&page=").append(page);
        builder.append("&page_size=").append(page_size);
        if (!Objects.isNull(filtering)) {
            builder.append("&filtering=").append(URIUtil.encodeURIComponent(JSON.toJSONString(filtering)));
        }
        return builder.toString();
    }

    @Data
    @Accessors(chain = true)
    public static class Filter {
        private List<Long> ids;
        private String landing_type;
        private String status;
        private List<String> fields;
    }
}
